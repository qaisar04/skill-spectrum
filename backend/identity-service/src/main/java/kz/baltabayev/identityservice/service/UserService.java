package kz.baltabayev.identityservice.service;

import kz.baltabayev.identityservice.client.InviteCodeClient;
import kz.baltabayev.identityservice.exception.InvalidCredentialsException;
import kz.baltabayev.identityservice.exception.PasswordMismatchException;
import kz.baltabayev.identityservice.exception.UserAlreadyExistsException;
import kz.baltabayev.identityservice.exception.UserNotFoundException;
import kz.baltabayev.identityservice.mapper.UserMapper;
import kz.baltabayev.identityservice.model.dto.*;
import kz.baltabayev.identityservice.model.entity.User;
import kz.baltabayev.identityservice.model.payload.DeveloperSavingRequest;
import kz.baltabayev.identityservice.model.payload.SavingRequest;
import kz.baltabayev.identityservice.model.types.Role;
import kz.baltabayev.identityservice.repository.UserRepository;
import kz.baltabayev.identityservice.utils.JwtTokenUtils;
import kz.baltabayev.loggingstarter.annotations.LoggableInfo;
import kz.baltabayev.loggingstarter.annotations.LoggableTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@LoggableInfo
@LoggableTime(name = "UserService")
public class UserService {

    private final UserRepository userRepository;
    private final InviteCodeClient inviteCodeClient;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenUtils jwtTokenUtils;
    private final PasswordEncoder passwordEncoder;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.kafka.queues.develop}")
    private String developQueue;

    @Value("${spring.kafka.queues.manager}")
    private String managerQueue;

    @Value("${spring.kafka.queues.admin}")
    private String adminQueue;

    @Value("${spring.kafka.queues.email}")
    private String emailSendingQueue;

    public SecurityResponse register(UserRequest userRequest) {
        validatePasswordConfirmation(userRequest.getPassword(), userRequest.getConfirmPassword());

        User user = userMapper.toUser(userRequest);
        String inviteCode = userRequest.getInviteCode();

        if (!inviteCode.isBlank() && !inviteCode.isEmpty()) {
            user.setRole(inviteCodeClient.useInviteCode(inviteCode).getBody());
            checkRole(userRequest, user);
        } else {
            user.setRole(Role.DEV_INTERN);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);

//        sendGreetingEmail(userRequest);
        return new SecurityResponse(user, token);
    }

    public SecurityResponse authenticate(AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password())
            );
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.username());
        User user = findByUsername(authRequest.username());
        String token = jwtTokenUtils.generateToken(userDetails);

        return new SecurityResponse(user, token);
    }

    private void validatePasswordConfirmation(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new PasswordMismatchException("Passwords don't match.");
        }
    }

    private void sendGreetingEmail(UserRequest userRequest) {
        kafkaTemplate.send(emailSendingQueue, new EmailMessageDto(
                userRequest.getEmail(), "Hello, " + userRequest.getName() + "! Welcome to our service!"));
    }

    private void checkRole(UserRequest userRequest, User user) {
        Map<Role, String> roleToQueueMap = new HashMap<>();
        roleToQueueMap.put(Role.MANAGER, managerQueue);
        roleToQueueMap.put(Role.ADMIN, adminQueue);

        String role = user.getRole().name();
        if (role.startsWith("DEV_")) {
            String roleWithoutPrefix = role.substring(4);
            kafkaTemplate.send(developQueue, new DeveloperSavingRequest(
                    userRequest.getName(), userRequest.getEmail(), roleWithoutPrefix
            ));
        } else {
            String queueName = roleToQueueMap.get(user.getRole());
            if (queueName != null) {
                kafkaTemplate.send(queueName, new SavingRequest(
                        userRequest.getName(), userRequest.getEmail()
                ));
            }
        }
    }

    public String generateInviteCode(String role) {
        return inviteCodeClient.generate(role).getBody();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }
}
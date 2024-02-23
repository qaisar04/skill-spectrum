package kz.baltabayev.identityservice.controller;

import jakarta.validation.Valid;
import kz.baltabayev.identityservice.model.dto.AuthRequest;
import kz.baltabayev.identityservice.model.dto.SecurityResponse;
import kz.baltabayev.identityservice.model.dto.TokenResponse;
import kz.baltabayev.identityservice.model.dto.UserRequest;
import kz.baltabayev.identityservice.model.entity.User;
import kz.baltabayev.identityservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class SecurityController {

    private final UserService userService;

    @PostMapping("/register")
    ResponseEntity<SecurityResponse> register(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.register(userRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(userService.authenticate(authRequest));
    }

    @PostMapping("/info")
    public ResponseEntity<User> getInfo(@RequestBody TokenResponse token) {
        return ResponseEntity.ok(userService.getInfo(token));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/generate/{role}")
    public ResponseEntity<String> generate(@PathVariable String role) {
        return ResponseEntity.ok(userService.generateInviteCode(role.toUpperCase()));
    }
}

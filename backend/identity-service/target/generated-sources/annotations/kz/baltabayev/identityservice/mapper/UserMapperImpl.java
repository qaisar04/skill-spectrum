package kz.baltabayev.identityservice.mapper;

import javax.annotation.processing.Generated;
import kz.baltabayev.identityservice.model.dto.UserRequest;
import kz.baltabayev.identityservice.model.entity.User;
import kz.baltabayev.identityservice.model.payload.StudentRequest;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T10:01:31+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User user = new User();

        user.setName( userRequest.getName() );
        user.setUsername( userRequest.getUsername() );
        user.setEmail( userRequest.getEmail() );
        user.setPassword( userRequest.getPassword() );

        return user;
    }

    @Override
    public StudentRequest toStudentRequest(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        String name = null;
        String email = null;

        name = userRequest.getName();
        email = userRequest.getEmail();

        StudentRequest studentRequest = new StudentRequest( name, email );

        return studentRequest;
    }
}

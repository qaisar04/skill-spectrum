package kz.baltabayev.identityservice.mapper;

import kz.baltabayev.identityservice.model.dto.UserRequest;
import kz.baltabayev.identityservice.model.entity.User;
import org.apache.catalina.authenticator.SavedRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toUser(UserRequest userRequest);

    SavedRequest toDto(UserRequest userRequest);
}

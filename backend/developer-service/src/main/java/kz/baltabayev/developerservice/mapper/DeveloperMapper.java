package kz.baltabayev.developerservice.mapper;

import kz.baltabayev.developerservice.model.dto.DeveloperRequest;
import kz.baltabayev.developerservice.model.entity.Developer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "developerInfo.firstname", source = "firstname"),
            @Mapping(target = "developerInfo.lastname", source = "lastname"),
            @Mapping(target = "developerInfo.birthDate", source = "birthDate"),
            @Mapping(target = "developerInfo.gender", source = "gender"),
            @Mapping(target = "developerInfo.position", source = "position"),
    })
    Developer toEntity(DeveloperRequest dto);

    @InheritInverseConfiguration(name = "toEntity")
    DeveloperRequest toDto(Developer entity);
}

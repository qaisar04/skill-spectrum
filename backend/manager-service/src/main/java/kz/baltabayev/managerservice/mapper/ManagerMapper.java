package kz.baltabayev.managerservice.mapper;

import kz.baltabayev.managerservice.model.dto.ManagerRequest;
import kz.baltabayev.managerservice.model.entity.Manager;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "managerInfo.firstname", source = "firstname"),
            @Mapping(target = "managerInfo.lastname", source = "lastname"),
            @Mapping(target = "managerInfo.gender", source = "gender"),
            @Mapping(target = "managerInfo.birthDate", source = "birthDate")
    })
    Manager toEntity(ManagerRequest dto);

    @InheritInverseConfiguration(name = "toEntity")
    ManagerRequest toDto(Manager entity);
}

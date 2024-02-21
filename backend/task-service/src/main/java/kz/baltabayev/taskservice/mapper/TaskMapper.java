package kz.baltabayev.taskservice.mapper;

import kz.baltabayev.taskservice.model.dto.TaskDto;
import kz.baltabayev.taskservice.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Task toEntity(TaskDto dto);
}

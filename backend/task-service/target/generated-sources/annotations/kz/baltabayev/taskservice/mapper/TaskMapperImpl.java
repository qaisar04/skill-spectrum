package kz.baltabayev.taskservice.mapper;

import javax.annotation.processing.Generated;
import kz.baltabayev.taskservice.model.dto.TaskDto;
import kz.baltabayev.taskservice.model.entity.Task;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T20:57:17+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDto toDto(Task entity) {
        if ( entity == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        return taskDto;
    }

    @Override
    public Task toEntity(TaskDto dto) {
        if ( dto == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        return task.build();
    }
}

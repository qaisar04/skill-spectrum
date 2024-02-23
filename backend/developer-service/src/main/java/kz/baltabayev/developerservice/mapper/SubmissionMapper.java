package kz.baltabayev.developerservice.mapper;

import kz.baltabayev.developerservice.model.dto.SubmissionDto;
import kz.baltabayev.developerservice.model.entity.Submission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

    SubmissionDto toDto(Submission entity);

    @Mapping(target = "id", ignore = true)
    Submission toEntity(SubmissionDto dto);
}

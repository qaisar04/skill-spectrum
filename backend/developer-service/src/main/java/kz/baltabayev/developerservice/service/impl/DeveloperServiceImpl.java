package kz.baltabayev.developerservice.service.impl;

import kz.baltabayev.developerservice.client.GradeServiceClient;
import kz.baltabayev.developerservice.client.TaskServiceClient;
import kz.baltabayev.developerservice.exception.DeveloperNotFoundException;
import kz.baltabayev.developerservice.mapper.DeveloperMapper;
import kz.baltabayev.developerservice.model.dto.DeveloperInfoResponse;
import kz.baltabayev.developerservice.model.dto.DeveloperRequest;
import kz.baltabayev.developerservice.model.dto.SubmissionDto;
import kz.baltabayev.developerservice.model.entity.Developer;
import kz.baltabayev.developerservice.model.entity.Submission;
import kz.baltabayev.developerservice.model.payload.Task;
import kz.baltabayev.developerservice.repository.DeveloperRepository;
import kz.baltabayev.developerservice.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;
    private final TaskServiceClient taskServiceClient;
    private final GradeServiceClient gradeServiceClient;

    @Override
    public DeveloperInfoResponse getInfo(Long id) {
        DeveloperRequest developerRequest = developerMapper.toDto(get(id));
        List<Task> tasks = getByDeveloperId(id);
        return new DeveloperInfoResponse(developerRequest, tasks);
    }

//    public Double getAverageCodeQuality(Long devId) {
//        List<Task> taskList = getByDeveloperId(devId);
//        return taskList.stream()
//                .map(task -> gradeServiceClient.getByTaskId(task.getId()).getBody())
//                .filter(Objects::nonNull)
//                .mapToDouble(grade -> Double.parseDouble(grade.getCodeQuality()))
//                .average()
//                .orElse(0.0);
//    }

    @Override
    public List<Task> getByDeveloperId(Long id) {
        return taskServiceClient.getTasksByDeveloperId(id).getBody();
    }

    @Override
    public void delete(Long id) {
        developerRepository.deleteById(id);
    }

    @Override
    public Developer get(Long id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new DeveloperNotFoundException(id));
    }

    @Override
    public Developer save(Developer dev) {
        return developerRepository.save(dev);
    }

    @Override
    public Developer update(Developer dev) {
        return developerRepository.save(dev);
    }

    @Override
    public List<Developer> getAll() {
        return developerRepository.findAll();
    }
}

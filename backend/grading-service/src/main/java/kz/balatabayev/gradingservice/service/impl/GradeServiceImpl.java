package kz.balatabayev.gradingservice.service.impl;

import kz.balatabayev.gradingservice.model.Grade;
import kz.balatabayev.gradingservice.reposiroty.GradeRepository;
import kz.balatabayev.gradingservice.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Override
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade getByTaskId(Long taskId) {
        return gradeRepository.findByTaskId(taskId);
    }
}

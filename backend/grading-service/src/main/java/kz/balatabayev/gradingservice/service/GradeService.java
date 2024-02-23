package kz.balatabayev.gradingservice.service;

import kz.balatabayev.gradingservice.model.Grade;

public interface GradeService {

    Grade save(Grade grade);

    Grade getByTaskId(Long taskId);

}

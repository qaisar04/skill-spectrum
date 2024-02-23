package kz.balatabayev.gradingservice.reposiroty;

import kz.balatabayev.gradingservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    Grade findByTaskId(Long taskId);
}

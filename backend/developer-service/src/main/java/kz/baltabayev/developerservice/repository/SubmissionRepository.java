package kz.baltabayev.developerservice.repository;


import kz.baltabayev.developerservice.model.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}

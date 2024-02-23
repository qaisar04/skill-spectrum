package kz.baltabayev.reviewerservice.repository;

import kz.baltabayev.reviewerservice.model.entity.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {
}

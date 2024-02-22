package kz.baltabayev.taskservice.repository;

import kz.baltabayev.taskservice.model.entity.Task;
import kz.baltabayev.taskservice.model.types.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByAssignedDeveloperId(Long id);
}

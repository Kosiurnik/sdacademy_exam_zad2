package pl.sdacademy.tarr.exam.ex2.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByUserId(Long userId);
    List<Task> findAllByTaskStatus(TaskStatus taskStatus);
    List<Task> findAllByTaskType(TaskType taskType);
    List<Task> findAllByTaskTypeAndUserId(TaskType taskType, Long userId);
    List<Task> findAllByTaskStatusAndUserId(TaskStatus taskStatus, Long userId);
    List<Task> findAllByTaskStatusAndTaskTypeAndUserId(TaskStatus taskStatus, TaskType taskType, Long userId);
}

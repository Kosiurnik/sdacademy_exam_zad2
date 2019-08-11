package pl.sdacademy.tarr.exam.ex2.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sdacademy.tarr.exam.ex2.user.UserRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    public List<Task> getTasksByStatus(TaskStatus taskStatus) {
        return taskRepository.findAllByTaskStatus(taskStatus);
    }

    public List<Task> getTasksByType(TaskType taskType) {
        return taskRepository.findAllByTaskType(taskType);
    }

    public List<Task> getUserTasksByStatus(TaskStatus taskStatus, Long userId) {
        return taskRepository.findAllByTaskStatusAndUserId(taskStatus, userId);
    }

    public List<Task> getUserTasksByType(TaskType taskType, Long userId) {
        return taskRepository.findAllByTaskTypeAndUserId(taskType, userId);
    }

    public List<Task> getUserTasksByTypeAndStatus(TaskStatus taskStatus, TaskType taskType, Long userId) {
        return taskRepository.findAllByTaskStatusAndTaskTypeAndUserId(taskStatus, taskType, userId);
    }

    public Task getTask(long id) {
        return taskRepository.getOne(id);
    }

    public void createTask(Long userId, Task task) {
        userRepository.findById(userId).ifPresent(user -> {
            task.setUser(user);
            taskRepository.save(task);
        });
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public void updateTaskUser(Task task, long userId) {
        userRepository.findById(userId).ifPresent(user -> {
            task.setUser(user);
            taskRepository.save(task);
        });
    }
}

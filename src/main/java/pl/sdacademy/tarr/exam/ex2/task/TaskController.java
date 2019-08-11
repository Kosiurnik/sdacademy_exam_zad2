package pl.sdacademy.tarr.exam.ex2.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.tarr.exam.ex2.task.dto.CreateTaskDTO;
import pl.sdacademy.tarr.exam.ex2.task.dto.TaskDTO;
import pl.sdacademy.tarr.exam.ex2.task.dto.UpdateTaskDTO;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks() {
        List<Task> tasks = taskService.getTasks();

        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/status/{status}")
    public List<TaskDTO> getUserTasks(@PathVariable TaskStatus status) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/type/{type}")
    public List<TaskDTO> getUserTasks(@PathVariable TaskType type) {
        List<Task> tasks = taskService.getTasksByType(type);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/user/{userId}")
    public List<TaskDTO> getUserTasks(@PathVariable long userId) {
        List<Task> tasks = taskService.getTasksByUser(userId);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/user/{userId}/{status}")
    public List<TaskDTO> getUserTasksByStatus(@PathVariable TaskStatus status, @PathVariable long userId) {
        List<Task> tasks = taskService.getUserTasksByStatus(status,userId);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/user/{userId}/{type}")
    public List<TaskDTO> getUserTasksByType(@PathVariable TaskType type, @PathVariable long userId) {
        List<Task> tasks = taskService.getUserTasksByType(type,userId);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/tasks/user/{userId}/{status}/{type}")
    public List<TaskDTO> getUserTasksByStatusAndType(@PathVariable TaskStatus status, @PathVariable TaskType type, @PathVariable long userId) {
        List<Task> tasks = taskService.getUserTasksByTypeAndStatus(status,type,userId);
        return taskMapper.toDTOs(tasks);
    }

    @GetMapping("/task/{taskId}")
    public TaskDTO getTask(@PathVariable long taskId) {
        Task task = taskService.getTask(taskId);

        return taskMapper.toDTO(task);
    }

    @PostMapping("/tasks/{userId}")
    public void createTask(CreateTaskDTO taskDTO, @PathVariable long userId) {
        Task task = taskMapper.fromDTO(taskDTO);
        taskService.createTask(userId,task);
    }

    @PutMapping("/tasks/{taskId}")
    public void updateTask(UpdateTaskDTO taskDTO, @PathVariable long taskId) {
        Task taskFromDb = taskService.getTask(taskId);

        if (taskFromDb != null) {
            Task task = taskMapper.fromDTO(taskDTO);
            task.setUser(taskFromDb.getUser());
            task.setId(taskId);
            taskService.updateTask(task);
        }
    }

    @PutMapping("/tasks/{taskId}/{userId}")
    public void updateTaskUser(@PathVariable long taskId, @PathVariable long userId) {
        Task taskFromDb = taskService.getTask(taskId);
        if (taskFromDb != null) {
            taskService.updateTaskUser(taskFromDb, userId);
        }
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable long taskId) {
        taskService.deleteTask(taskId);
    }
}

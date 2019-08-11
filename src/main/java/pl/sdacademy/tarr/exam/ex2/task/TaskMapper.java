package pl.sdacademy.tarr.exam.ex2.task;

import org.springframework.stereotype.Component;
import pl.sdacademy.tarr.exam.ex2.task.dto.CreateTaskDTO;
import pl.sdacademy.tarr.exam.ex2.task.dto.TaskDTO;
import pl.sdacademy.tarr.exam.ex2.task.dto.UpdateTaskDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(), task.getUser().getId(),task.getTitle(), task.getTaskStatus(), task.getTaskType());
    }

    public List<TaskDTO> toDTOs(List<Task> tasks) {
        return tasks.stream()
                .map(task -> toDTO(task))
                .collect(Collectors.toList());
    }

    public Task fromDTO(CreateTaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setTaskType(taskDTO.getTaskType());
        return task;
    }

    public Task fromDTO(UpdateTaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setTaskStatus(taskDTO.getTaskStatus());
        task.setTaskType(taskDTO.getTaskType());
        return task;
    }
}

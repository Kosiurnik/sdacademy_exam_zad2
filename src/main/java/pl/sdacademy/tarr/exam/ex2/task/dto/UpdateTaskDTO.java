package pl.sdacademy.tarr.exam.ex2.task.dto;

import pl.sdacademy.tarr.exam.ex2.task.TaskStatus;
import pl.sdacademy.tarr.exam.ex2.task.TaskType;

import java.io.Serializable;

public class UpdateTaskDTO implements Serializable {

    private final String title;
    private final TaskStatus taskStatus;
    private final TaskType taskType;

    public UpdateTaskDTO(String title, TaskStatus taskStatus, TaskType taskType) {
        this.title = title;
        this.taskStatus = taskStatus;
        this.taskType = taskType;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        return "UpdateTaskDTO{" +
                "title='" + title + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskType=" + taskType +
                '}';
    }
}

package pl.sdacademy.tarr.exam.ex2.task.dto;

import lombok.Data;
import pl.sdacademy.tarr.exam.ex2.task.TaskStatus;
import pl.sdacademy.tarr.exam.ex2.task.TaskType;

import java.io.Serializable;

public class TaskDTO implements Serializable {

    private final long id;
    private final long userId;
    private final String title;
    private final TaskStatus taskStatus;
    private final TaskType taskType;

    public TaskDTO(long id, long userId, String title, TaskStatus taskStatus, TaskType taskType) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.taskStatus = taskStatus;
        this.taskType = taskType;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
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
        return "TaskDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", taskStatus=" + taskStatus +
                ", taskType=" + taskType +
                '}';
    }
}

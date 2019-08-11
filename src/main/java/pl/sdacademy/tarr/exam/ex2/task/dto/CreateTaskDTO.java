package pl.sdacademy.tarr.exam.ex2.task.dto;

import pl.sdacademy.tarr.exam.ex2.task.TaskType;

import java.io.Serializable;

public class CreateTaskDTO implements Serializable {

    private final String title;
    private final TaskType taskType;

    public CreateTaskDTO(String title, TaskType taskType) {
        this.title = title;
        this.taskType = taskType;
    }

    public String getTitle() {
        return title;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    @Override
    public String toString() {
        return "CreateTaskDTO{" +
                "title='" + title + '\'' +
                ", taskType=" + taskType +
                '}';
    }
}

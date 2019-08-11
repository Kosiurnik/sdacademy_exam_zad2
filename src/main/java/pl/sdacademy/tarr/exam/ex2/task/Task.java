package pl.sdacademy.tarr.exam.ex2.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.sdacademy.tarr.exam.ex2.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    private TaskType taskType = TaskType.TASK;

    private TaskStatus taskStatus = TaskStatus.NEW;
}

package pl.sdacademy.tarr.exam.ex2.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import pl.sdacademy.tarr.exam.ex2.task.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@JsonIgnore
	@OneToMany(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			mappedBy = "user")
	private List<Task> tasks = new ArrayList<>();


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

}

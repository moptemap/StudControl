package by.pavel.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_task_result")
public class UserTaskResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "task_status_id", referencedColumnName = "id", nullable = false)
    private TaskStatus taskStatus;

}

package by.pavel.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "theme")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private long courseId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @OneToMany(mappedBy = "theme")
    private List<Lecture> lectures;

    @OneToMany(mappedBy = "theme")
    private List<Task> tasks;
}

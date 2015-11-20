package by.pavel.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "theme_id", referencedColumnName = "id", nullable = false)
    private Theme theme;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Type(type = "text")
    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "file_path", nullable = true, length = 500)
    private String filePath;

}

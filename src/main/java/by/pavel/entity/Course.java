package by.pavel.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private long id;

    @Size(min = 4, max = 100, message = "Course name must be between 3 and 100 characters long.")
    @Column(name = "name", nullable = false, insertable = true, unique = true, updatable = true, length = 100)
    private String name;

    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 500)
    private String description;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return !(name != null ? !name.equals(course.name) : course.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

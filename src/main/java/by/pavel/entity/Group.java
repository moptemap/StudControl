package by.pavel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private long id;

    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    private String name;

    @Column(name = "translit_name", nullable = false, length = 70)
    private String translatedName;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "start_course_date", nullable = false, insertable = true, updatable = true)
    private Date startCourseDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "end_course_date", nullable = false, insertable = true, updatable = true)
    private Date endCourseDate;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;

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

    public String getTranslatedName() {
        return translatedName;
    }

    public void setTranslatedName(String translatedName) {
        this.translatedName = translatedName;
    }

    public Date getStartCourseDate() {
        return startCourseDate;
    }

    public void setStartCourseDate(Date startCourseDate) {
        this.startCourseDate = startCourseDate;
    }

    public Date getEndCourseDate() {
        return endCourseDate;
    }

    public void setEndCourseDate(Date endCourseDate) {
        this.endCourseDate = endCourseDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        return !(translatedName != null ? !translatedName.equals(group.translatedName) : group.translatedName != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (translatedName != null ? translatedName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", translatedName='" + translatedName + '\'' +
                ", startCourseDate=" + startCourseDate +
                ", endCourseDate=" + endCourseDate +
                '}';
    }
}
package by.pavel.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lecture_comment")
public class LectureComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "lecture_id", referencedColumnName = "id", nullable = false)
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "text", nullable = false, length = 500)
    private String text;

    @Column(name = "send_time", nullable = false, columnDefinition="timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;

}

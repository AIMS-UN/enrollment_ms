package co.edu.unal.aims.enrollment_ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "enrollments")
@Data @AllArgsConstructor @NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Integer id;
    @Column(name = "user_id")
    private String user;
    @Column(name = "group_id")
    private String group;
    @Column(name = "subject_id")
    private String subject;
    private String semester;
    @Column(name = "final_grade")
    private Double finalGrade;

    public Enrollment(String user, String group, String subject, String semester, Double finalGrade) {
        this.user = user;
        this.group = group;
        this.subject = subject;
        this.semester = semester;
        this.finalGrade = finalGrade;
    }
}

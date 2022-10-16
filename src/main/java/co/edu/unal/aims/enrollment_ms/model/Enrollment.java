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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enrollment_id", insertable = false, updatable = false, nullable = false)
    private UUID id;
    @Column(name = "user_id", updatable = false, nullable = false)
    private String user;
    @Column(name = "group_id", updatable = false, nullable = false)
    private String group;
    @Column(name = "subject_id", updatable = false, nullable = false)
    private String subject;
    @Column(name = "semester", updatable = false, nullable = false)
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

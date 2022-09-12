package co.edu.unal.aims.enrollment_ms.repository;

import co.edu.unal.aims.enrollment_ms.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    public List<Enrollment> findAllByUser(String user_uuid);
    public List<Enrollment> findAllByGroup(String group_id);
    public List<Enrollment> findAllBySubject(String subject_id);
    public List<Enrollment> findAllBySemester(String semester);
    public List<Enrollment> findAllByUserAndSemester(String user_uuid, String semester);
    public List<Enrollment> findAllBySubjectAndSemester(String subject_id, String semester);
    public Enrollment findByUserAndSubject(String user_uuid, String subject_id);
}

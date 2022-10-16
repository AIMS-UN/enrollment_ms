package co.edu.unal.aims.enrollment_ms.repository;

import co.edu.unal.aims.enrollment_ms.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
    List<Enrollment> findAllByUser(String user_uuid);
    List<Enrollment> findAllBySubject(String subject_id);
    List<Enrollment> findAllBySemester(String semester);
    List<Enrollment> findAllByUserAndSemester(String user_uuid, String semester);
    List<Enrollment> findAllBySubjectAndSemester(String subject_id, String semester);
    List<Enrollment> findAllBySubjectAndGroup(String subject_id, String group_id);
    List<Enrollment> findAllByUserAndSubject(String user_uuid, String subject_id);
    Enrollment findByUserAndSubjectAndSemester(String user_uuid, String subject_id, String semester);
}

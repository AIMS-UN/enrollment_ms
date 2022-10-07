package co.edu.unal.aims.enrollment_ms.service;

import co.edu.unal.aims.enrollment_ms.model.Enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment getEnrollment(int id);
    Enrollment createEnrollment(Enrollment enrollment);
    Enrollment deleteEnrollment(String user, String subject, String semester);
    Enrollment updateFinalGrade(String user, String subject, String semester, Double finalGrade);

    List<Enrollment> findAll();
    List<Enrollment> findByUser(String uuid);
    List<Enrollment> findBySubject(String subject);
    List<Enrollment> findBySemester(String semester);
    List<Enrollment> findByUserAndSemester(String uuid, String semester);
    List<Enrollment> findBySubjectAndSemester(String subject, String semester);
    List<Enrollment> findBySubjectAndGroup(String subject, String group);
    List<Enrollment> findByUserAndSubject(String uuid, String subject);
}

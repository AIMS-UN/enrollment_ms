package co.edu.unal.aims.enrollment_ms.service;

import co.edu.unal.aims.enrollment_ms.model.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {

    public Enrollment getEnrollment(int id);
    public Enrollment createEnrollment(Enrollment enrollment);
    public Enrollment deleteEnrollment(String user, String subject);
    public Enrollment updateFinalGrade(String user, String subject, Double finalGrade);

    public List<Enrollment> findByUser(String uuid);
    public List<Enrollment> findByGroup(String group);
    public List<Enrollment> findBySubject(String subject);
    public List<Enrollment> findBySemester(String semester);
    public List<Enrollment> findByUserAndSemester(String uuid, String semester);
    public List<Enrollment> findBySubjectAndSemester(String subject, String semester);
}

package co.edu.unal.aims.enrollment_ms.service;

import co.edu.unal.aims.enrollment_ms.model.Enrollment;
import co.edu.unal.aims.enrollment_ms.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment getEnrollment(int id) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(null);
        return enrollment;
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment deleteEnrollment(String user, String subject) {
        Enrollment enrollment  = enrollmentRepository.findByUserAndSubject(user, subject);
        if (enrollment == null){
            return null;
        }
        enrollmentRepository.delete(enrollment);
        return enrollment;
    }

    @Override
    public Enrollment updateFinalGrade(String user, String subject, Double finalGrade) {
        Enrollment enrollment = enrollmentRepository.findByUserAndSubject(user, subject);
        if (enrollment == null){
            return null;
        }
        enrollment.setFinalGrade(finalGrade);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> findByUser(String uuid) {
        return enrollmentRepository.findAllByUser(uuid);
    }

    @Override
    public List<Enrollment> findByGroup(String group) {
        return enrollmentRepository.findAllByGroup(group);
    }

    @Override
    public List<Enrollment> findBySubject(String subject) {
        return enrollmentRepository.findAllBySubject(subject);
    }

    @Override
    public List<Enrollment> findBySemester(String semester) {
        return enrollmentRepository.findAllBySemester(semester);
    }

    @Override
    public List<Enrollment> findByUserAndSemester(String uuid, String semester) {
        return enrollmentRepository.findAllByUserAndSemester(uuid, semester);
    }

    @Override
    public List<Enrollment> findBySubjectAndSemester(String subject, String semester) {
        return enrollmentRepository.findAllBySubjectAndSemester(subject, semester);
    }
}

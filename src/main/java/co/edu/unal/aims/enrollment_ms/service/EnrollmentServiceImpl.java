package co.edu.unal.aims.enrollment_ms.service;

import co.edu.unal.aims.enrollment_ms.model.Enrollment;
import co.edu.unal.aims.enrollment_ms.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment getEnrollment(UUID id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment deleteEnrollment(String user, String subject, String semester) {
        Enrollment enrollment  = enrollmentRepository.findByUserAndSubjectAndSemester(user, subject, semester);
        if (enrollment == null){
            return null;
        }
        enrollmentRepository.delete(enrollment);
        return enrollment;
    }

    @Override
    public Enrollment updateFinalGrade(String user, String subject, String semester, Double finalGrade) {
        Enrollment enrollment = enrollmentRepository.findByUserAndSubjectAndSemester(user, subject, semester);
        if (enrollment == null){
            return null;
        }
        enrollment.setFinalGrade(finalGrade);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> findAll(){
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Enrollment> findByUser(String uuid) {
        return enrollmentRepository.findAllByUser(uuid);
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

    @Override
    public List<Enrollment> findBySubjectAndGroup(String subject, String group) {
        return enrollmentRepository.findAllBySubjectAndGroup(subject, group);
    }

    @Override
    public List<Enrollment> findByUserAndSubject(String uuid, String subject) {
        return enrollmentRepository.findAllByUserAndSubject(uuid, subject);
    }
}

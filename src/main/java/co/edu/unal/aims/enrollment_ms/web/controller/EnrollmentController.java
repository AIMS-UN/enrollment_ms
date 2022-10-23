package co.edu.unal.aims.enrollment_ms.web.controller;

import co.edu.unal.aims.enrollment_ms.model.Enrollment;
import co.edu.unal.aims.enrollment_ms.service.EnrollmentService;
import co.edu.unal.aims.enrollment_ms.web.dto.EnrollmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getEnrollments(@RequestParam(name="user", required=false) String userId,
                                                           @RequestParam(name="group", required=false) String groupId,
                                                           @RequestParam(name="subject", required=false) String subjectId,
                                                           @RequestParam(name="semester", required=false) String semester){
        List<Enrollment> enrollments = new ArrayList<Enrollment>();
        
        if(userId != null && groupId == null  && subjectId == null && semester == null){
            enrollments = enrollmentService.findByUser(userId);
        }else if(userId == null && groupId == null  && subjectId != null && semester == null){
            enrollments = enrollmentService.findBySubject(subjectId);
        }else if(userId == null && groupId == null  && subjectId == null && semester != null){
            enrollments = enrollmentService.findBySemester(semester);
        }else if(userId != null && groupId == null  && subjectId == null && semester != null){
            enrollments = enrollmentService.findByUserAndSemester(userId, semester);
        }else if(userId == null && groupId == null  && subjectId != null && semester != null){
            enrollments = enrollmentService.findBySubjectAndSemester(subjectId, semester);
        }else if(userId == null && groupId != null  && subjectId != null && semester == null){
            enrollments = enrollmentService.findBySubjectAndGroup(subjectId, groupId);
        }else if(userId != null && groupId == null  && subjectId != null && semester == null){
            enrollments = enrollmentService.findByUserAndSubject(userId, subjectId);
        }else if(userId == null && groupId == null  && subjectId == null && semester == null){
            enrollments = enrollmentService.findAll();
        }else{
            System.out.println("NO CONTENT");
            return ResponseEntity.ok(enrollments).noContent().build();
        }

        if (enrollments.isEmpty()){
            System.out.println("LIST EMPTY");
            return ResponseEntity.ok(enrollments).noContent().build();
        }
        
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollment(@PathVariable("id") UUID id){
        Enrollment enrollment = enrollmentService.getEnrollment(id);
        if (enrollment == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enrollment);
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody EnrollmentDto enrollmentDto){
        Enrollment enrollment = new Enrollment(
                enrollmentDto.getUser(),
                enrollmentDto.getGroup(),
                enrollmentDto.getSubject(),
                enrollmentDto.getSemester(),
                null
        );
        Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEnrollment);
    }

    @DeleteMapping
    public ResponseEntity<Enrollment> cancelEnrollment(@RequestParam(name = "user") String user,
                                                       @RequestParam(name = "subject") String subject,
                                                       @RequestParam(name = "semester") String semester){
        Enrollment enrollmentDeleted = enrollmentService.deleteEnrollment(user, subject, semester);
        if (enrollmentDeleted == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(enrollmentDeleted);
    }

    @PutMapping("/grade")
    public ResponseEntity<Enrollment> updateFinalGrade(@RequestBody EnrollmentDto enrollmentDto){
        String user = enrollmentDto.getUser();
        String subjectId = enrollmentDto.getSubject();
        String semester = enrollmentDto.getSemester();
        Double finalGrade = enrollmentDto.getFinalGrade();

        Enrollment enrollment = enrollmentService.updateFinalGrade(user, subjectId, semester, finalGrade);
        if (enrollment == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(enrollment);
    }
}

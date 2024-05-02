package cyborg.springframework.restapis.rest;

import cyborg.springframework.restapis.entity.Student;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data ... only once

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("Shashikant", "Solanki"));
        students.add(new Student("Garv Pratap", "Singh"));
        students.add(new Student("Mary Murphy", "Singh"));
        students.add(new Student("Saurabh", "Jain"));
        students.add(new Student("Utkarsh", "Kharakwal"));

    }



    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    // define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exp) {

        // create a StudentErrorResponse

        StudentErrorResponse response = new StudentErrorResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exp.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    // add another exception handler.. to catch any exception(catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {

        // create a StudentErrorResponse

        StudentErrorResponse response = new StudentErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}

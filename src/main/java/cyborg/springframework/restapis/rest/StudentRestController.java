package cyborg.springframework.restapis.rest;

import cyborg.springframework.restapis.entity.Student;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return students.get(studentId);
    }
}

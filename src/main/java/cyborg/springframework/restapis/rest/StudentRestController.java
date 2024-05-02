package cyborg.springframework.restapis.rest;

import cyborg.springframework.restapis.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Jane", "Doe"));
        students.add(new Student("Jack", "Doe"));

        return students;

    }

}

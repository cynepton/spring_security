package com.cynepton.spring_security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * StudentController
 * <br>
 * <code>com.cynepton.spring_security.student.StudentController</code>
 * <br>
 *
 * @author Isaac Aderonmu
 * @since 09 October 2021
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Bruce", "Wayne"),
            new Student(2, "Diana", "Prince"),
            new Student(3, "Kitty", "Pryde"),
            new Student(4, "Selina", "Kyle" )
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " was not " +
                        "found"));
    }
}

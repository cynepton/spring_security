package com.cynepton.spring_security.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * StudentManagementController
 * <br>
 * <code>com.cynepton.spring_security.student.StudentManagementController</code>
 * <br>
 *
 * @author Isaac Aderonmu
 * @since 01 November 2021
 */
@RestController
@RequestMapping("api/v1/admin/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Bruce", "Wayne"),
            new Student(2, "Diana", "Prince"),
            new Student(3, "Kitty", "Pryde"),
            new Student(4, "Selina", "Kyle" )
    );

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        System.out.println("Add New Student");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println("Delete Student");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId,
                              @RequestBody Student student) {
        System.out.println("Update Student");
        System.out.println(studentId + " " + student);
    }
}

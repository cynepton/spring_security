package com.cynepton.spring_security.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Student
 * <br>
 * <code>com.cynepton.spring_security.student.Student</code>
 * <br>
 *
 * @author Isaac Aderonmu
 * @since 09 October 2021
 */
@Getter
@Setter
@AllArgsConstructor
public class Student {

    private final Integer studentId;
    private String firstName;
    private String lastName;

    public Student(Integer studentId) {
        this.studentId = studentId;
    }
}

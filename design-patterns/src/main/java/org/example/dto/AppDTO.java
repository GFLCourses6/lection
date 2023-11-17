package org.example.dto;

import org.example.dto.mapper.StudentMapper;
import org.example.dto.model.dto.StudentCredentials;
import org.example.dto.model.entity.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class AppDTO {
    public static void main(String[] args) {
        AppDTO app = new AppDTO();
        app.run();
    }

    public void run() {
        var credentials = new StudentCredentials("alex", "zanchenko", "leshaGFL", "12345");
        var student = StudentMapper.mapToStudent(credentials);
        System.out.println(student);

        var student2 = new Student(
                1L,
                "Alex",
                "Zanchenko",
                25,
                "123 Main St",
                "alex@example.com",
                "123-456-7890",
                new Date(),
                Arrays.asList("Java", "English"),
                "leshaGFL",
                "password");
        var credentials2 = StudentMapper.mapToStudentCredentials(student2);
        System.out.println(credentials2);
    }
}

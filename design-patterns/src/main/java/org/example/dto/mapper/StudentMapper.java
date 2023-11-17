package org.example.dto.mapper;

import org.example.dto.model.entity.Student;
import org.example.dto.model.dto.StudentCredentials;
public class StudentMapper {

    public static StudentCredentials mapToStudentCredentials(Student student){
        return new Student.StudentBuilder()
                .name(student.getName())
                .surname(student.getSurname())
                .login(student.getLogin())
                .password(student.getPassword())
                .buildStudentCredentials();
    }
    public static Student mapToStudent(StudentCredentials studentCredentials){
        return new Student.StudentBuilder()
                .name(studentCredentials.getName())
                .surname(studentCredentials.getSurname())
                .login(studentCredentials.getLogin())
                .password(studentCredentials.getPassword())
                .buildStudent();
    }
}

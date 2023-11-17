package org.example.dto.model.entity;

import org.example.dto.model.dto.StudentCredentials;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Student {
    private Long studentId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int age;
    private String address;
    private String email;
    private String phoneNumber;
    private Date birthDate;
    private List<String> courses;

    public Student(){
    }
    public Student(Long studentId, String name, String surname, int age, String address, String email, String phoneNumber, Date birthDate, List<String> courses, String login, String password) {
        this.studentId = studentId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.courses = courses;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(studentId, student.studentId)
                && Objects.equals(name, student.name)
                && Objects.equals(surname, student.surname)
                && Objects.equals(address, student.address)
                && Objects.equals(email, student.email)
                && Objects.equals(phoneNumber, student.phoneNumber)
                && Objects.equals(birthDate, student.birthDate)
                && Objects.equals(courses, student.courses)
                && Objects.equals(login, student.login)
                && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, surname, age, address, email, phoneNumber, birthDate, courses, login, password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Student{")
                .append("studentId=").append(studentId).append('\'')
                .append(", name=").append(name).append('\'')
                .append(", surname='").append(surname).append('\'')
                .append(", login=").append(login)
                .append(", password=").append(password)
                .append(",  age=").append(age)
                .append(", address=").append(address)
                .append(", email=").append(email)
                .append(", phoneNumber=").append(phoneNumber)
                .append(", birthDate=").append(birthDate)
                .append(", courses=").append(courses)
                .append('}').toString();
    }

    public static class StudentBuilder{
        private Long studentId;
        private String login;
        private String password;
        private String name;
        private String surname;
        private int age;
        private String address;
        private String email;
        private String phoneNumber;
        private Date birthDate;
        private List<String> courses;

        public StudentBuilder(){
        }

        public StudentBuilder studentId(Long studentId){
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder login(String login){
            this.login = login;
            return this;
        }
        public StudentBuilder password(String password){
            this.password = password;
            return this;
        }
        public StudentBuilder name(String name){
            this.name = name;
            return this;
        }
        public StudentBuilder surname(String surname){
            this.surname = surname;
            return this;
        }
        public StudentBuilder age(int age){
            this.age = age;
            return this;
        }
        public StudentBuilder address(String address){
            this.address = address;
            return this;
        }
        public StudentBuilder email(String email){
            this.email = email;
            return this;
        }
        public StudentBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public StudentBuilder birthDate(Date birthDate){
            this.birthDate = birthDate;
            return this;
        }
        public StudentBuilder courses(List<String> courses){
            this.courses = courses;
            return this;
        }

        public Student buildStudent() {
            return new Student(studentId, name, surname, age, address, email, phoneNumber, birthDate, courses, login, password);
        }
        public StudentCredentials buildStudentCredentials() {
            return new StudentCredentials(name, surname, login, password);
        }
    }
}

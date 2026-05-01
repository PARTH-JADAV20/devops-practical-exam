package com.example.studentcrud.model;
import jakarta.persistence.*;

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String course;

    @Column(length = 15)
    private String phone;

    public Student() {}

    public Student(String name, String email, String course, String phone) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getCourse() {
        return course;
    }
    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}

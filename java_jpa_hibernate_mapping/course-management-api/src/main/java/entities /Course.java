package com.techcamps.course.management.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    
    @ManyToMany
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students = new ArrayList<>();

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private CourseMaterial courseMaterial;

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.getCourses().add(this);
    }

    public void setMaterial(CourseMaterial material) {
        this.courseMaterial = material;
        material.setCourse(this);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Teacher getTeacher() { return teacher; }
    public List<Student> getStudents() { return students; }
    public CourseMaterial getCourseMaterial() { return courseMaterial; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    @Override
    public String toString() {
        return "Course { id=" + id + ", name='" + name + "' }";
    }
}

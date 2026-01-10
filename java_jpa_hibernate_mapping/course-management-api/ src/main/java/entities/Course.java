package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

   
    @ManyToOne(optional = false)
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
    private CourseMaterial material;

    public Course() {}

    public Course(String title) { this.title = title; }

    public void addStudent(Student student) {
        students.add(student);
        if (!student.getCourses().contains(this)) {
            student.getCourses().add(this);
        }
    }

    public void setMaterial(CourseMaterial material) {
        this.material = material;
        if (material != null) material.setCourse(this);
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public List<Student> getStudents() { return students; }
    public CourseMaterial getMaterial() { return material; }
}

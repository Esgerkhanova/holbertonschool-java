package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

  
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

  
    public void addAddress(Address address) {
        addresses.add(address);
        address.setStudent(this);
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
        phone.setStudent(this);
    }

    public void addCourse(Course course) {
        courses.add(course);
        if (!course.getStudents().contains(this)) {
            course.getStudents().add(this);
        }
    }


    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Address> getAddresses() { return addresses; }
    public List<Phone> getPhones() { return phones; }
    public List<Course> getCourses() { return courses; }
}

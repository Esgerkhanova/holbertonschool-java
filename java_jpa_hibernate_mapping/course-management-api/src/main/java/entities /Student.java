package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String fullName;


    @Column(nullable = false, unique = true)
    private String registration;

    
    @Temporal(TemporalType.DATE)
    private Date birthDate;


    @Column(nullable = false)
    private String email;



    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    

    public Student() {}

    public Student(String fullName, String registration, Date birthDate, String email) {
        this.fullName = fullName;
        this.registration = registration;
        this.birthDate = birthDate;
        this.email = email;
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

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getRegistration() { return registration; }
    public void setRegistration(String registration) { this.registration = registration; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Address> getAddresses() { return addresses; }
    public List<Phone> getPhones() { return phones; }
    public List<Course> getCourses() { return courses; }
}

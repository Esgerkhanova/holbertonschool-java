package entities;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    public Address() {}

    public Address(String street) {
        this.street = street;
    }

    public Long getId() { return id; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}

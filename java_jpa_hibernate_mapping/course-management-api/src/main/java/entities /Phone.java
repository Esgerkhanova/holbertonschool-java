package entities;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    public Phone() {}

    public Phone(String number) {
        this.number = number;
    }

    public Long getId() { return id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}

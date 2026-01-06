package com.techcamps.registrations.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private int age;
    private String cpf;

    private LocalDate birthDate;

}

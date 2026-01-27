package com.example.jpa_h2_demo.repositories;

import com.example.jpa_h2_demo.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}

package com.example.jpa_h2_demo.repositories;

import com.example.jpa_h2_demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

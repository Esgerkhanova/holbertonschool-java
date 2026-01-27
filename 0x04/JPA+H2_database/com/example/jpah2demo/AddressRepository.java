package com.example.jpa_h2_demo.repositories;

import com.example.jpa_h2_demo.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

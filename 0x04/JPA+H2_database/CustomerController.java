package com.example.jpa_h2_demo.controllers;

import com.example.jpa_h2_demo.entities.Customer;
import com.example.jpa_h2_demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Customer> addClient(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Customer>> findAllClients() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Customer> findClientById(@PathVariable("id") Long idClient) {
        Optional<Customer> customer = customerRepository.findById(idClient);
        return customer.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/removeClientById/{id}")
    public ResponseEntity<Void> removeCustomer(@PathVariable("id") Long idClient) {
        customerRepository.deleteById(idClient);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateClientById/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("id") Long id,
                                               @RequestBody Customer customer) {
        customer.setId(id);
        customerRepository.save(customer);
        return ResponseEntity.noContent().build();
    }
}

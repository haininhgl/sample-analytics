package com.example.sample.controller;

import com.example.sample.domain.Customer;
import com.example.sample.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.data.domain.Pageable;
import java.net.URI;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //Return all Customer
    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    //Return a customer by id
    @GetMapping("/customers{id}")
    public ResponseEntity<?> getAllCustomersById(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    // Create a customer
    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {
        customerRepository.save(customer);

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();

        responseHeaders.setLocation(newCustomerUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // Update a customer by id
    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomerById(@PathVariable String id, @RequestBody @Valid Customer customer) {
        customerRepository.save(customer);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete a customer by id
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable String id) {
        customerRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

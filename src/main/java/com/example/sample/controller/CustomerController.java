package com.example.sample.controller;

import com.example.sample.dto.mapper.CustomerMapper;
import com.example.sample.entity.Customer;
import com.example.sample.exception.ResourceNotFoundException;
import com.example.sample.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    private final CustomerMapper customerMapper;
    public CustomerController(CustomerService customerService,CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getAllPost() {
        List<Customer> customer = customerService.getAllCustomers();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @GetMapping("/customers/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") String id) throws ResourceNotFoundException {
        Customer customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customerMapper.toDto(customer), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {
        Customer newCustomer = customerService.createCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public ResponseEntity<?> updateCustomer(@RequestBody @Valid Customer customer) throws ResourceNotFoundException {
        Customer newCustomer = customerService.updateCustomer(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable @Valid String id) throws ResourceNotFoundException {
        customerService.deleteCustomer(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

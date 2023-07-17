package com.example.sample.service;

import com.example.sample.entity.Customer;
import com.example.sample.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomerById(String id) throws ResourceNotFoundException;

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer) throws ResourceNotFoundException;

    void deleteCustomer(String id) throws ResourceNotFoundException;

}

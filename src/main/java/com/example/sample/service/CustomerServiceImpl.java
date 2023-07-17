package com.example.sample.service;

import com.example.sample.entity.Customer;
import com.example.sample.exception.ResourceNotFoundException;
import com.example.sample.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }
    @Override
    public Customer getCustomerById(String id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws ResourceNotFoundException {
        Customer currentCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if (currentCustomer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer not found!");
        }

        customerRepository.deleteById(id);
    }

//    @Override
//    public Page<Account> getAccountsByCustomerId(String id, Pageable pageable) throws ResourceNotFoundException {
//        Customer customer = customerRepository.findById(id).orElse(null);
//        if (customer == null) {
//            throw new ResourceNotFoundException("Customer not found!");
//        }
//
//        List<Account> accountList = accountRepository.getAccountsByCustomerId(customer.getAccounts());
//
//        return new PageImpl<>(accountList, pageable, accountList.size());
//    }

}
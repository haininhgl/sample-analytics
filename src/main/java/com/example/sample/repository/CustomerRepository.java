package com.example.sample.repository;

import com.example.sample.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Page<Customer> findAll(Pageable pageable);
}


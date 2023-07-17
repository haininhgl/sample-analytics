package com.example.sample.repository;

import com.example.sample.entity.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Qualifier("transactions")
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    Page<Transaction> findAll(Pageable pageable);

//    Optional<Transaction> updateTransactionById(String id);

    Optional<Transaction> deleteAllById(String id);
}

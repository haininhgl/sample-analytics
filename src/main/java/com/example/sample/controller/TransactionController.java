package com.example.sample.controller;



import com.example.sample.domain.Transaction;
import com.example.sample.repository.TransactionRepository;
import com.example.sample.service.transaction.TransactionServiceImpl;
import com.example.sample.service.transaction.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
public class TransactionController {
    @Autowired
    private TransactionsService transactionService;

    // Return all transactions
    @GetMapping("/transactions")
    public ResponseEntity<?> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAll();

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // Return a transaction by id
    @GetMapping("/transactions/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
        Transaction transaction = transactionService.getById(id);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    // Create a transaction
    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(@RequestBody @Valid Transaction transaction) {
        transactionRepository.save(transaction);

        HttpHeaders responseHeaders = new HttpHeaders();

        URI newTransactionUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(transaction.getId())
                .toUri();

        responseHeaders.setLocation(newTransactionUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // Update a transaction by id
//    @PutMapping("/transactions/{id}")
//    public ResponseEntity<?> updateTransactionById(@PathVariable String id, @RequestBody @Valid Transaction transaction) {
//        Transaction transaction1 = transactionService.save(transaction);
//
//        return new ResponseEntity<>(transaction1,HttpStatus.OK);
//    }

    // Delete a transaction by id
//    @DeleteMapping("/transactions/{id}")
//    public ResponseEntity<?> deleteTransactionById(@PathVariable String id) {
//        Transaction transaction = transactionService.deleteById(id);
//
//        return new ResponseEntity<>(transaction,HttpStatus.OK);
//    }

}


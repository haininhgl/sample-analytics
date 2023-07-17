package com.example.sample.controller;

import com.example.sample.entity.Transaction;
import com.example.sample.service.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
@Validated
public class TransactionController {

    private final TransactionsService transactionService;

    public TransactionController(TransactionsService transactionService) {
        this.transactionService = transactionService;
    }

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
        Transaction transaction1 = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(transaction1, HttpStatus.OK);

    }

    // Update a transaction by id
    @PutMapping("/transactions/{id}")
    public ResponseEntity<?> updateTransaction(@RequestBody Transaction transaction, @PathVariable String id) {
        Transaction newTransaction = transactionService.updateTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

    // Delete a transaction by id
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<?> deleteTransactionById(@PathVariable String id) {
        Transaction transaction = transactionService.deleteTransactionById(id);

        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

}


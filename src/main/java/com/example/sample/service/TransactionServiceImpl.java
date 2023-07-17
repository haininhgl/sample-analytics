package com.example.sample.service.transaction;

import com.example.sample.domain.Transaction;
import com.example.sample.repository.TransactionRepository;

import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Component
public class TransactionServiceImpl implements TransactionsService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction getById(String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.orElse(null);

    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        Transaction currentTransaction = transactionRepository.findById(transaction.getId()).orElse(null);
        if (currentTransaction == null) {
           throw new IllegalArgumentException("Transaction not found!");
        }
        return transactionRepository.save(transaction);
    }
    @Override
    public Transaction deleteTransactionById(@PathVariable String id) {
        Optional<Transaction> transaction = transactionRepository.deleteAllById(id);
            return deleteTransactionById(id);
    }
}

package com.example.sample.service.transaction;

import com.example.sample.domain.Transaction;
import com.example.sample.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionsService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction getById(String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.orElse(null);

    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

//    @Override
//    public Transaction updateTransactionById(@PathVariable String id) {
//        Optional<Transaction> transaction = transactionRepository.updateTransactionById(id)
//    }
}

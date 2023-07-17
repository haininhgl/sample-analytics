package com.example.sample.service.transaction;

import com.example.sample.domain.Transaction;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TransactionsService {

    Transaction getById(String id);

    List<Transaction> getAll();

    Transaction createTransaction(Transaction transaction);

    Transaction deleteTransactionById(@PathVariable String id);

    Transaction updateTransaction(Transaction transaction);
}

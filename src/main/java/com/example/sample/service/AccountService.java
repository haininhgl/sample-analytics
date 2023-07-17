package com.example.sample.service;

import com.example.sample.domain.Account;
import com.example.sample.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface AccountServive {

    Page<Account> getAllAccount(Pageable pageable);

    Account getAccountById(String id) throws ResourceNotFoundException;

    Account createAccount(Account account);

    Account updateAccount(Account account) throws ResourceNotFoundException;

    void deleteById(String id) throws ResourceNotFoundException;
}

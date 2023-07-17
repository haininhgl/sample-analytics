package com.example.sample.service;

import com.example.sample.dto.AccountDTO;
import com.example.sample.entity.Account;
import com.example.sample.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountService {


    List<Account> getAllAccount();

    Account getAccountById(String id) throws ResourceNotFoundException;

    Account createAccount(Account account);

    void updateAccount(String id, AccountDTO accountDTO);

    void deleteById(String id) throws ResourceNotFoundException;

}

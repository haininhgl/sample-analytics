package com.example.sample.service;


import com.example.sample.dto.AccountDTO;
import com.example.sample.entity.Account;
import com.example.sample.exception.ResourceNotFoundException;
import com.example.sample.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(String id) throws ResourceNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            throw new ResourceNotFoundException("Account not found!");
        }

        return account;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void updateAccount(String id, AccountDTO accountDTO) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            BeanUtils.copyProperties(accountDTO, account);
            accountRepository.save(account);
        }
    }

    @Override
    public void deleteById(String id) throws ResourceNotFoundException {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            throw new ResourceNotFoundException("Account not found!");
        }

        accountRepository.deleteById(id);
    }


}

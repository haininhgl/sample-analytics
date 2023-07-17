package com.example.sample.service.transaction;


import com.example.sample.domain.Account;
import com.example.sample.exception.ResourceNotFoundException;
import com.example.sample.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public abstract class AccountServiceImpl implements AccountServive {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Page<Account> getAllAccount(Pageable pageable) {
        return accountRepository.getAllAccount(pageable);
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
    public Account updateAccount(Account account) throws ResourceNotFoundException {
        Account newAccount = accountRepository.findById(account.getId()).orElse(null);
        if (newAccount == null) {
            throw new ResourceNotFoundException("Account not found!");
        }

        return accountRepository.save(account);
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

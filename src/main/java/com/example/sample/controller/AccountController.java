package com.example.sample.controller;

import com.example.sample.dto.AccountDTO;
import com.example.sample.dto.mapper.AccountMapper;
import com.example.sample.entity.Account;
import com.example.sample.exception.ResourceNotFoundException;
import com.example.sample.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
@Validated
public class AccountController {

    private final AccountService accountService;

    @Autowired
    private final AccountMapper accountMapper;
    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    //return all accounts
    @GetMapping("/accounts")
    public ResponseEntity<?> getAllPost() {
        List<Account> accounts = accountService.getAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
//    return account by id
    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable("id") String id) {
        try {
            Account account = accountService.getAccountById(id);

            return new ResponseEntity<>(accountMapper.toDto(account), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //create an account
    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody @Valid Account account) {
        Account newAccount = accountService.createAccount(account);

        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    //Update an account

    @PutMapping("/accounts/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable String id, @RequestBody AccountDTO accountDTO) {
        try {
            // Gọi phương thức cập nhật thông tin tài khoản từ AccountService
            accountService.updateAccount(id, accountDTO);
            return new ResponseEntity<>("Account updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //Delete an account by id

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> DeleteAccountById(@PathVariable String id, @RequestBody @Valid Account account) throws ResourceNotFoundException {
        accountService.deleteById(id);
        return  new ResponseEntity<>((HttpStatus.OK));
    }
}


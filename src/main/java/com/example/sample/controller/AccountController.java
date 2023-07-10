package com.example.sample.controller;

import com.example.sample.domain.Account;
import com.example.sample.repository.AccountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.data.domain.Pageable;
import java.net.URI;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    //return all accounts
    @GetMapping("/accounts")
    public ResponseEntity<?> getAllPosts(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    //return account by id
    @GetMapping("/accounts/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable String id) {
        Optional<Account> account = accountRepository.findById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    //create a transaction
    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody @Valid Account account) {
        accountRepository.save(account);

        HttpHeaders responseHearders = new HttpHeaders();

        URI newAccountUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(account.getId())
                .toUri();

        responseHearders.setLocation(newAccountUri);
        return new ResponseEntity<>(null, responseHearders, HttpStatus.CREATED);
    }

    //Update an account by id

    @PutMapping("/accounts/{id}")
    public ResponseEntity<?> updateAccountById(@PathVariable String id, @RequestBody @Valid Account account) {
        accountRepository.save(account);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Delete an account by id

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> DeleteAccountById(@PathVariable String id, @RequestBody @Valid Account account){
        accountRepository.deleteById(id);

        return  new ResponseEntity<>((HttpStatus.OK));
    }
}

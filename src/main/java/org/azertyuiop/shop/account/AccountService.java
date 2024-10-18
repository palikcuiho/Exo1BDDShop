package org.azertyuiop.shop.account;

//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;

import org.azertyuiop.shop.exception.UserAlreadyExistsException;

import java.util.List;
import java.util.Optional;

//@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
            return accountRepository.save(account);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public boolean doesUserExist(String username) {
        Optional<Account> a = findByUsername(username);
        return a.isPresent();
    }

    public void registerAccount(Account account) {
        if (!this.doesUserExist(account.getUsername()))
            accountRepository.save(account);
        else throw new UserAlreadyExistsException(account.getUsername());
    }
}

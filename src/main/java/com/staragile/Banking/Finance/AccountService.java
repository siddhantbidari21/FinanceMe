package com.staragile.Banking.Finance;

import java.util.ArrayList; // Import ArrayList
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountDAORepository accountDAORepository;

    public List<Account> getAccounts() {
        List<Account> accountList = new ArrayList<>(); // Create a new ArrayList
        accountDAORepository.findAll().forEach(accountList::add);
        return accountList;
    }

    // Other methods...


    public Optional<Account> getAccount(String id) {
        return accountDAORepository.findById(id);
    }

    public void addAccount(Account account) {
        accountDAORepository.save(account);
    }

    public void updateAccount(String id, Account account) {
        accountDAORepository.save(account);
    }

    public void viewAccount(String id, Account account) {
        accountDAORepository.save(account);
    }

    public void deleteAccount(String id) {
        accountDAORepository.deleteById(id);
    }
}


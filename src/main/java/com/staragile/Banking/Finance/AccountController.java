package com.staragile.Banking.Finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/hello")
    public String doSomething() {
        return "Hello World";
    }

    @RequestMapping("/seeddata")
    public String seedData() {
        System.out.println("Inside seeddata");
        Account p1 = new Account("1", "Vilas", "Vilas Address", "123456789");
        accountService.addAccount(p1);

        p1 = new Account("2", "Siddhant", "Siddhant Address", "11212121");
        accountService.addAccount(p1);

        return "Data seeded successfully!!!";
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccountById(@PathVariable String id) {
        System.out.println("Inside getAccountById");
        return accountService.getAccount(id);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping
    public String addAccount(@RequestBody Account account) {
        accountService.addAccount(account);
        return "Successfully added!!";
    }

    @PutMapping("/{id}")
    public String updateAccount(@RequestBody Account account, @PathVariable String id) {
        accountService.updateAccount(id, account);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return "Deleted successfully";
    }
}


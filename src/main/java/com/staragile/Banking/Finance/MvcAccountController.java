package com.staragile.Banking.Finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MvcAccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/mvchello")
    public String doSomething() {
        return "Hello World!!!";
    }

    @RequestMapping("/getallaccount")
    public String getAllAccounts(Model model) {
        List<Account> accountList = accountService.getAccounts();
        model.addAttribute("accountList", accountList);
        return "account";
    }

    @PostMapping("/createaccount")
    public String addAccount(HttpServletRequest req, HttpServletResponse res) {
        Account account = new Account();
        account.setAccountId(req.getParameter("id"));
        account.setCustomerName(req.getParameter("name"));
        account.setCustomerAddress(req.getParameter("address"));
        account.setContactNumber(req.getParameter("contact"));
        accountService.addAccount(account);
        return "redirect:/getallaccount";
    }

    @PostMapping("/updateaccount")
    public String updateAccount(HttpServletRequest req, HttpServletResponse res) {
        Account account = new Account();
        account.setAccountId(req.getParameter("id"));
        account.setCustomerName(req.getParameter("name"));
        account.setCustomerAddress(req.getParameter("address"));
        account.setContactNumber(req.getParameter("contact"));
        accountService.updateAccount(req.getParameter("id"), account);
        return "redirect:/getallaccount";
    }

    @PostMapping("/viewaccount")
    public String viewAccount(HttpServletRequest req, HttpServletResponse res) {
        Account account = new Account();
        account.setAccountId(req.getParameter("id"));
        account.setCustomerName(req.getParameter("name"));
        account.setCustomerAddress(req.getParameter("address"));
        account.setContactNumber(req.getParameter("contact"));
        accountService.viewAccount(req.getParameter("id"), account);
        return "redirect:/getallaccount";
    }

    @GetMapping("/deleteaccount/{id}")
    public String deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return "redirect:/getallaccount";
    }
}

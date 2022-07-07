package nl.novi.backendrecipebble.controllers;

import nl.novi.backendrecipebble.models.Account;
import nl.novi.backendrecipebble.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping("/{id}")
    public Account saveAccount (@RequestBody Account account){
        return accountService.saveAccount(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account){
        return accountService.updateAccount(account, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
}

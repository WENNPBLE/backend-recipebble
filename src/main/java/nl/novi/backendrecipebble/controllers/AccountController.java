package nl.novi.backendrecipebble.controllers;
import nl.novi.backendrecipebble.dtos.AccountDto;
import nl.novi.backendrecipebble.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDto> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping
    public AccountDto saveAccount (@RequestBody AccountDto accountDto){
        return accountService.saveAccount(accountDto);
    }

    @PutMapping("/{id}")
    public AccountDto updateAccount(@PathVariable Long id, @RequestBody AccountDto accountDto){
        return accountService.updateAccount(accountDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
}

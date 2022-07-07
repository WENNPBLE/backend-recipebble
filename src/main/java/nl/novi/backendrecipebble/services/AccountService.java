package nl.novi.backendrecipebble.services;

import nl.novi.backendrecipebble.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account saveAccount(Account account);
    Account updateAccount(Account account, Long id);
    void deleteAccount(Long id);
}

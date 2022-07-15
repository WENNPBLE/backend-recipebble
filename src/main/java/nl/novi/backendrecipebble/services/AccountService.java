package nl.novi.backendrecipebble.services;
import nl.novi.backendrecipebble.dtos.AccountDto;


import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccounts();
    AccountDto getAccountById(Long id);
    AccountDto saveAccount(AccountDto accountDto);
    AccountDto updateAccount(AccountDto accountDto, Long id);
    void deleteAccount(Long id);
}

package nl.novi.backendrecipebble.services;

import nl.novi.backendrecipebble.dtos.AccountDto;
import nl.novi.backendrecipebble.exceptions.RecordNotFoundException;
import nl.novi.backendrecipebble.models.Account;
import nl.novi.backendrecipebble.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<AccountDto> accountDtos = new ArrayList<>();
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            AccountDto accountDto = transferAccountToAccountDto(account);
            accountDtos.add(accountDto);
        }
        return accountDtos;
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            Account account1 = account.get();
            AccountDto dto = transferAccountToAccountDto(account1);
            return dto;
        } else {
            throw new RecordNotFoundException("Could not find account");
        }
    }

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        Account account = transferAccountDtoToAccount(accountDto);
        Account account3 = accountRepository.save(account);
        AccountDto dto = transferAccountToAccountDto(account3);
        return dto;
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto, Long id) {
        Account account = transferAccountDtoToAccount(accountDto);
        Account account2 = transferAccount(account, id);
        accountRepository.save(account2);
        AccountDto dto = transferAccountToAccountDto(account2);
        return dto;
    }


    @Override
    public void deleteAccount(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Could not delete account");
        }
    }

    public Account transferAccount(Account account, Long id) {
        Optional<Account> account1 = accountRepository.findById(id);
        if (account1.isPresent()) {
            Account account2 = account1.get();

            account2.setId(account2.getId());
            account2.setName(account.getName());
            account2.setLastName(account.getLastName());
            account2.setDescription(account.getDescription());
            return account2;
        } else {
            throw new RecordNotFoundException("Could not update account");
        }
    }

    public AccountDto transferAccountToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();

        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setLastname(account.getLastName());
        accountDto.setDescription(account.getDescription());
        return accountDto;
    }

    public Account transferAccountDtoToAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setName(accountDto.getName());
        account.setLastName(accountDto.getLastname());
        account.setDescription(accountDto.getDescription());
        return account;
    }
}

package nl.novi.backendrecipebble.services;

import nl.novi.backendrecipebble.exceptions.RecordNotFoundException;
import nl.novi.backendrecipebble.models.Account;
import nl.novi.backendrecipebble.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new RecordNotFoundException("Could not find account");
        }
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account, Long id) {
        Account account2 = transferAccount(account, id);
        return accountRepository.save(account2);
    }

    @Override
    public void deleteAccount(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            accountRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Could not delete account");
        }
    }

    public Account transferAccount(Account account, Long id){
        Optional<Account> account1 = accountRepository.findById(id);
        if(account1.isPresent()){
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
}

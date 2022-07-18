package nl.novi.backendrecipebble.repositories;

import nl.novi.backendrecipebble.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getAccountByNameEqualsIgnoreCase(String name);
}

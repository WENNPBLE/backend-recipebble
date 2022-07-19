package nl.novi.backendrecipebble.repositories;

import nl.novi.backendrecipebble.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

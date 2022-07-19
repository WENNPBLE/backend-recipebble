package nl.novi.backendrecipebble.services;


import nl.novi.backendrecipebble.dtos.UserDto;
import nl.novi.backendrecipebble.models.Authority;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

    @Service
    public interface UserService {

List<UserDto> getUsers();
UserDto getUser(String username);
 boolean userExists(String username) ;
 String createUser(UserDto userDto);
 void deleteUser(String username) ;
 void updateUser(String username, UserDto newUser);
 Set<Authority> getAuthorities(String username);
 void addAuthority(String username, String authority);
 void removeAuthority(String username, String authority) ;

    }

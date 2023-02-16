package io.codekaffee.pocs.authserver.services;


import io.codekaffee.pocs.authserver.dtos.UserDTO;
import io.codekaffee.pocs.authserver.models.User;
import io.codekaffee.pocs.authserver.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User createUser(UserDTO userDTO) {
        String encodedPassword =  passwordEncoder.encode(userDTO.password());

        User user =  new User(userDTO, encodedPassword);

        return userRepository.save(user);
    }
}
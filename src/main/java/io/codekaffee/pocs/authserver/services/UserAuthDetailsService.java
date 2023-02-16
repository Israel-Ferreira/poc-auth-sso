package io.codekaffee.pocs.authserver.services;

import io.codekaffee.pocs.authserver.models.AuthServerUserDetails;
import io.codekaffee.pocs.authserver.models.User;
import io.codekaffee.pocs.authserver.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserAuthDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userPresent = userRepository.findByEmail(username);


        if(userPresent.isEmpty()){
            throw new  UsernameNotFoundException("erro: usuário não encontrado");
        }

        return new AuthServerUserDetails(userPresent.get());
    }
}
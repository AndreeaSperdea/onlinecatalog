package com.andreea.onlinecatalog.config;

import com.andreea.onlinecatalog.config.CustomUserDetails;
import com.andreea.onlinecatalog.model.User;
import com.andreea.onlinecatalog.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DatabaseUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public DatabaseUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));   //lambda, exceptia trebuie prinsa undeva
        return new CustomUserDetails(user);
    }
}
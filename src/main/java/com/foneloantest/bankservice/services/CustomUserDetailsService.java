package com.foneloantest.bankservice.services;

import com.foneloantest.bankservice.entities.CustomUserDetails;
import com.foneloantest.bankservice.entities.User;
import com.foneloantest.bankservice.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User with the username: "+username+" wasn't found"));
        return new CustomUserDetails(user);
    }
}

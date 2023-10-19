package com.example.demosecurity2.security;

import com.example.demosecurity2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private List<User> users = new ArrayList<>();

    public CustomUserDetailService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        users.add(new User(1, "Duy Anh", "anh@gmail.com", passwordEncoder.encode("123"), List.of("USER", "ADMIN")));
        users.add(new User(2, "Cường", "cuong@gmail.com", passwordEncoder.encode("123"), List.of("USER")));
        users.add(new User(3, "Duy ", "duy@gmail.com", passwordEncoder.encode("123"), List.of("USER")));
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = users.stream()
                .filter(user1 -> user1.getEmail().equals(email))
                .findFirst()
                .orElseThrow(()-> new UsernameNotFoundException("User not found with email: " + email));
        return new CustomUserDetail(user);
    }
}

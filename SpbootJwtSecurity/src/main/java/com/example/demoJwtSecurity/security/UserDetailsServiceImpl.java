package com.example.demoJwtSecurity.security;

import com.example.demoJwtSecurity.model.User;
import com.example.demoJwtSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userRepo
                .findOneByEmail(email)  // si usa il metodo con query personalizzato
                .orElseThrow(() -> new UsernameNotFoundException("l'utente con email " + email + " non è stato trovato"));   // se l'utente non è stato trovato si lancia l'eccezione
        
        return
    }
    
    
}

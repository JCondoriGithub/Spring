package com.example.demoJwtSecurity.repository;

import com.example.demoJwtSecurity.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    Optional<User> findOneByEmail(String email);    // si crea il metodo con la query personalizzata
}

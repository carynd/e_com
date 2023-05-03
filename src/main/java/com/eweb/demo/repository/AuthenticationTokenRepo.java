package com.eweb.demo.repository;

import com.eweb.demo.model.AuthenticationToken;
import com.eweb.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationTokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);
}

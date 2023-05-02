package com.eweb.demo.service;

import com.eweb.demo.model.AuthenticationToken;
import com.eweb.demo.model.User;
import com.eweb.demo.repository.AuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationTokenService {
    @Autowired
    AuthenticationTokenRepo authenticationTokenRepo;
    public void addToken(User user) {
        AuthenticationToken auth=new AuthenticationToken(user);
        authenticationTokenRepo.save(auth);
    }

    public AuthenticationToken findByUser(User user) {
        return authenticationTokenRepo.findByUser(user);
    }
}

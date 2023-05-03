package com.eweb.demo.service;

import com.eweb.demo.exceptions.AuthenticationFailed;
import com.eweb.demo.model.AuthenticationToken;
import com.eweb.demo.model.User;
import com.eweb.demo.repository.AuthenticationTokenRepo;
import com.eweb.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

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

    public void authenticate(String token) {
        if (Objects.isNull(token)) {
            throw new AuthenticationFailed("token is not present");
        }
    }

    public User getUserFromToken(String token) {
        AuthenticationToken authenticationToken=authenticationTokenRepo.findByToken(token);
        if(!Objects.isNull(authenticationToken)){
            return authenticationToken.getUser();
        }
        throw new AuthenticationFailed("No token exists");
    }
}

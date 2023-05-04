package com.eweb.demo.service;

import com.eweb.demo.dto.ResponseDto;
import com.eweb.demo.dto.SignUserDto.SignInDto;
import com.eweb.demo.dto.SignUserDto.SignInResponseDto;
import com.eweb.demo.dto.SignUserDto.SignUpDto;
import com.eweb.demo.exceptions.AuthenticationFailed;
import com.eweb.demo.exceptions.CustomException;
import com.eweb.demo.model.AuthenticationToken;
import com.eweb.demo.model.User;
import com.eweb.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthenticationTokenService authenticationTokenService;


    public boolean signUpCheck(SignUpDto signUpDto) {
        Optional<User> user= Optional.ofNullable(userRepo.findByEmail(signUpDto.getEmail()));
        if(!user.isPresent()){
            return false;
        }
        return true;
        //already signedIn, then verify

    }

    public User signUp(SignUpDto signUpDto, String encrptedPassword) {
        User user =new User(signUpDto.getFirstName(), signUpDto.getLastName(), signUpDto.getEmail(), encrptedPassword);
        userRepo.save(user);
        return user;
    }

    @Transactional
    public ResponseDto signUpFull(SignUpDto signUpDto) {
        boolean response = this.signUpCheck(signUpDto);
        if(response){
            throw new CustomException("user already present");
        }

        String encrptedPassword = signUpDto.getPassword();
        try{
            encrptedPassword = hashPassword(encrptedPassword);
        }
        catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
            throw new CustomException(ex.getMessage());
        }
        User user=this.signUp(signUpDto,encrptedPassword);
        authenticationTokenService.addToken(user);
        return new ResponseDto("Success","Signed Up successfully");
    }
    private String hashPassword(String encrptedPassword) throws NoSuchAlgorithmException {
        MessageDigest md=MessageDigest.getInstance("MD5");
        md.update(encrptedPassword.getBytes());
        byte[] digest=md.digest();
        String hashedPw= DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hashedPw;
    }

    public SignInResponseDto signIn(SignInDto signInDto) throws NoSuchAlgorithmException {
        User user= userRepo.findByEmail(signInDto.getEmail());
        if(Objects.isNull(user)) throw new AuthenticationFailed("No user found");

        //checking if the passwords match (as it is in hashed in user table, using same algo for hasing of input password)
        try{
            if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
                throw new AuthenticationFailed("wrong password");
            }
        }catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        //now get token for that user(token in UUID no)
        AuthenticationToken authenticationToken=authenticationTokenService.findByUser(user);
        if(Objects.isNull(authenticationToken)) throw new AuthenticationFailed("No such token exists");

        return new SignInResponseDto("success",authenticationToken.getToken());
    }
}

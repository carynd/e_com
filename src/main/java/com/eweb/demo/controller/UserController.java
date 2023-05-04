package com.eweb.demo.controller;

import com.eweb.demo.dto.ResponseDto;
import com.eweb.demo.dto.SignUserDto.SignInDto;
import com.eweb.demo.dto.SignUserDto.SignInResponseDto;
import com.eweb.demo.dto.SignUserDto.SignUpDto;
import com.eweb.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUpFull(signUpDto);
    }

    @PostMapping("signin")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) throws NoSuchAlgorithmException {
        return userService.signIn(signInDto);
    }
}

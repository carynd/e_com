package com.eweb.demo.dto.SignUserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
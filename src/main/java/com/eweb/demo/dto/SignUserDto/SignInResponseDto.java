package com.eweb.demo.dto.SignUserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignInResponseDto {
    private String status;
    private String token;
}

package com.eweb.demo.exceptions;

public class AuthenticationFailed extends IllegalArgumentException {
    public AuthenticationFailed(String msg){
        super(msg);
    }
}

package com.sparta.mungmung.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String userName;
    private String password;
    private String dogName;
    private String confirmPassword;
}

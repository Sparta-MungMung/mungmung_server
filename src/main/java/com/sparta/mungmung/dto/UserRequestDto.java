package com.sparta.mungmung.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {

    private String userName;
    private String dogName;
    private String dogImage;
    private String password;


}

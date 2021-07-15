package com.sparta.mungmung.domain;


import com.sparta.mungmung.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String dogName;

    @Column(nullable = true)
    private String dogImage;

    @Column(nullable = false)
    private String password;

    public User(String userName, String password, String dogName, String dogImage){
        this.userName = userName;
        this.dogName = dogName;
        this.password = password;
        this.dogImage = dogImage;
    }

    public void update(UserRequestDto requestDto){
        this.dogImage = requestDto.getDogImage();
    }

    public void updateDogImage(String dogImage){
        this.dogImage = dogImage;
    }
}

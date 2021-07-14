package com.sparta.mungmung.controller;

import com.sparta.mungmung.dto.SignupRequestDto;
import com.sparta.mungmung.dto.UserRequestDto;
import com.sparta.mungmung.security.UserDetailsImpl;
import com.sparta.mungmung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/regist")
    public void userRegister(@RequestBody SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
    }

    //사진 저장
    @PostMapping("/userinfo/image")
    public void setImage(@RequestBody UserRequestDto userRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        userService.setImage(userRequestDto, userDetails.getUser());
    }
    //로그인
    @PostMapping("/user")
    public String login(@RequestBody UserRequestDto user) {
        return userService.createToken(user);
    }

}

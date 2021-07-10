package com.sparta.mungmung.controller;



import com.sparta.mungmung.dto.MyPageResponseDto;
import com.sparta.mungmung.dto.SignupRequestDto;
import com.sparta.mungmung.security.UserDetailsImpl;
import com.sparta.mungmung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/regist")
    public void userRegister(SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
    }

    // 마이페이지 정보
    @GetMapping("/userinfo")
    public MyPageResponseDto userInfo(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return userService.findUserInfo(userDetails.getUser());
    }


}

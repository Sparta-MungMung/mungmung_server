package com.sparta.mungmung.controller;

import com.sparta.mungmung.domain.User;
import com.sparta.mungmung.dto.MyPageResponseDto;
import com.sparta.mungmung.dto.SignupRequestDto;
import com.sparta.mungmung.dto.UserRequestDto;
import com.sparta.mungmung.exception.ApiRequestException;
import com.sparta.mungmung.repository.UserRepository;
import com.sparta.mungmung.security.JwtTokenProvider;
import com.sparta.mungmung.security.UserDetailsImpl;
import com.sparta.mungmung.service.ReservationService;
import com.sparta.mungmung.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ReservationService reservationService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    //회원가입
    @PostMapping("/user/regist")
    public void userRegister(@RequestBody SignupRequestDto signupRequestDto){
        userService.registerUser(signupRequestDto);
    }

    // 마이페이지 정보
    @GetMapping("/userinfo")
    public MyPageResponseDto userInfo(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return reservationService.findUserInfo(userDetails.getUser());
    }

    //사진 저장
    @PostMapping("/userinfo/image")
    public void setImage(@RequestBody UserRequestDto userRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        userService.setImage(userRequestDto, userDetails.getUser());
    }
    //로그인
    @PostMapping("/user")
    public String login(@RequestBody Map<String,String> user) {
        User member = userRepository.findByUserName(user.get("userName"))
                .orElseThrow(() -> new ApiRequestException("존재하지 않는 아이디입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new ApiRequestException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUserName());
    }

}

package com.sparta.mungmung.controller;

import com.sparta.mungmung.dto.MyPageResponseDto;
import com.sparta.mungmung.dto.ReservationRequestDto;
import com.sparta.mungmung.security.UserDetailsImpl;
import com.sparta.mungmung.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

    private final ReservationService reservationService;

    // 예약정보 저장
    @PostMapping("/reservations")
    public void reservation(@RequestBody ReservationRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        reservationService.addReservation(requestDto, userDetails.getUser());
    }

    // 마이페이지 정보
    @GetMapping("/userinfo")
    public MyPageResponseDto userInfo(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return reservationService.findUserInfo(userDetails.getUser());
    }
}
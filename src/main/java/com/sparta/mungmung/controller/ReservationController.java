package com.sparta.mungmung.controller;

import com.sparta.mungmung.dto.ReservationRequestDto;
import com.sparta.mungmung.security.UserDetailsImpl;
import com.sparta.mungmung.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    // 예약정보 저장
    @PostMapping("/reservations")
    public void reservation(@RequestBody ReservationRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        reservationService.addReservation(requestDto, userDetails.getUser());
    }
}

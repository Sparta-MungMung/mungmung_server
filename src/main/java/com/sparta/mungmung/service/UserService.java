package com.sparta.mungmung.service;

import com.sparta.mungmung.domain.User;
import com.sparta.mungmung.dto.MyPageResponseDto;
import com.sparta.mungmung.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ReservationRepository reservationRepository;

    public MyPageResponseDto findUserInfo(User user){

        MyPageResponseDto myPageResponseDto = new MyPageResponseDto();
        myPageResponseDto.setUser(user);
        myPageResponseDto.setReservation(reservationRepository.findAllByUserId(user.getUserId()));

        return myPageResponseDto;
    }

}

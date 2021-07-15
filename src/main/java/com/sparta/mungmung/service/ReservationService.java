package com.sparta.mungmung.service;

import com.sparta.mungmung.domain.Hospital;
import com.sparta.mungmung.domain.Reservation;
import com.sparta.mungmung.domain.User;
import com.sparta.mungmung.dto.MyPageResponseDto;
import com.sparta.mungmung.dto.ReservationRequestDto;
import com.sparta.mungmung.repository.HospitalRepository;
import com.sparta.mungmung.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final HospitalRepository hospitalRepository;


    public void addReservation(ReservationRequestDto requestDto, User user){
        Hospital hospital = hospitalRepository.findById(requestDto.getHospitalId()).orElseThrow(
                ()-> new NullPointerException("No ID")
        );
        requestDto.setHospitalName(hospital.getHospitalName());
        Reservation reservation = new Reservation(requestDto, user.getUserId());
        reservationRepository.save(reservation);
    }


    public MyPageResponseDto findUserInfo(User user){

        MyPageResponseDto myPageResponseDto = new MyPageResponseDto();
        myPageResponseDto.setUser(user);
        myPageResponseDto.setReservation(reservationRepository.findAllByUserId(user.getUserId()));

        return myPageResponseDto;
    }
}



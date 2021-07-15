package com.sparta.mungmung.dto;

import com.sparta.mungmung.domain.Reservation;
import com.sparta.mungmung.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyPageResponseDto {

    private User user;
    private List<Reservation> reservation;

}

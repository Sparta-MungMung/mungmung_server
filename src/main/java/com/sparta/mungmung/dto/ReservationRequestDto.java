package com.sparta.mungmung.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequestDto {

    private String reservationDetail;
    private String reservationDate;
    private Long hospitalId;

}

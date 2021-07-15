package com.sparta.mungmung.domain;

import com.sparta.mungmung.dto.ReservationRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Reservation extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long reservationId;

    @Column(nullable = true)
    private String reservationDetail;

    @Column(nullable = false)
    private String reservationDate;

    @Column(nullable = false)
    private Long hospitalId;

    @Column(nullable = false)
    private String hospitalName;

    @Column(nullable = false)
    private Long userId;

    public Reservation(ReservationRequestDto requestDto, Long userId){
        this.reservationDetail = requestDto.getReservationDetail();
        this.reservationDate = requestDto.getReservationDate();
        this.hospitalId = requestDto.getHospitalId();
        this.hospitalName = requestDto.getHospitalName();
        this.userId = userId;
    }

}
package com.sparta.mungmung.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Reservation {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long reservationId;

    @Column(nullable = false)
    private String reservationDetail;

    @Column(nullable = false)
    private String reservationDate;

}
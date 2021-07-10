package com.sparta.mungmung.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Hospital {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long hospitalId;

    @Column(nullable = false)
    private String hospitalName;

    @Column(nullable = false)
    private String hospitalContent;

    @Column(nullable = false)
    private Float hospitalRate;

    @Column(nullable = false)
    private String hospitalLocation;

    @Column(nullable = false)
    private String hospitalNumber;

    @Column(nullable = false)
    private String hospitalImageSource;


    public void updateHospitalRate(long reviewRate, int reviewCount) {
        float rateSum = this.hospitalRate * (reviewCount - 1);
        float newHospitalRate = (rateSum + reviewRate) / reviewCount;
        this.hospitalRate = newHospitalRate;
    }

}

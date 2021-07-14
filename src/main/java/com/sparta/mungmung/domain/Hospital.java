package com.sparta.mungmung.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity
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

    @OneToMany
    private List<HospitalImage> hospitalImageList;

    @ManyToMany
    private List<Subject> subjectList;

    public void updateHospitalRate(float hospitalAverageRate) {
        this.hospitalRate = hospitalAverageRate;
    }
    public String getHospitalName(){
        return this.hospitalName;
    }



}

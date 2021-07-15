package com.sparta.mungmung.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class HospitalImage {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long hospitalImageId;

    @Column(nullable = false, length = 100000)
    private String hospitalImageUrl;
}

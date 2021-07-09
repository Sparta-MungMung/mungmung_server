package com.sparta.mungmung.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
public class Review {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long reviewId;

    @Column(nullable = false)
    private String reviewContent;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

}

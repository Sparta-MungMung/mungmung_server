package com.sparta.mungmung.domain;

import com.sparta.mungmung.dto.ReviewRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
public class Review extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long reviewId;

    @Column(nullable = false)
    private String reviewContent;

    @Column(nullable = false)
    private Long hospitalId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long reviewRate;

    public Review(ReviewRequestDto reviewRequestDto) {
        this.reviewContent = reviewRequestDto.getReviewContent();
        this.hospitalId = reviewRequestDto.getHospitalId();
        this.userId = reviewRequestDto.getUserId();
        this.reviewRate = reviewRequestDto.getReviewRate();
    }

    public void update(ReviewRequestDto reviewRequestDto) {
        this.reviewContent = reviewRequestDto.getReviewContent();
        this.reviewRate = reviewRequestDto.getReviewRate();
    }
}

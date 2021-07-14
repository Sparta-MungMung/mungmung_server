package com.sparta.mungmung.domain;

import com.sparta.mungmung.dto.ReviewRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @Test
    @DisplayName("정상케이스")
    void createReview_Normal() {
        String reviewContent = "zhaps";
        Long hospitalId = 100L;
        Long userId = 102L;
        Long hospitalRate = 4L;

//        ReviewRequestDto requestDto = new ReviewRequestDto(reviewContent,hospitalId,userId, hospitalRate);


//        Review review = new Review(requestDto);
    }
}
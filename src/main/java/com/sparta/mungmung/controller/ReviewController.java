package com.sparta.mungmung.controller;

import com.sparta.mungmung.domain.Review;
import com.sparta.mungmung.dto.ReviewRequestDto;
import com.sparta.mungmung.repository.ReviewRepository;
import com.sparta.mungmung.security.UserDetailsImpl;
import com.sparta.mungmung.service.ReviewService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    //리뷰 조회
    @GetMapping("/hospital/{id}/reviews")
    public List<Review> getReviewList(@PathVariable(name = "id") Long hospitalId) {
        return reviewService.findReview(hospitalId);
    }

    //리뷰 작성
    @PostMapping("/hospital/{id}/reviews")
    public void createReview(@PathVariable(name = "id") Long hospitalId, ReviewRequestDto reviewRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            Long userId = userDetails.getUser().getUserId();
            reviewService.saveReview(reviewRequestDto, hospitalId, userId);
        } else {
            // user login 안했을 때 반환해주는 것 구현 예정
        }
    }

    //리뷰 수정
    @PutMapping("/hospital/reviews/{id}")
    public void updateReview(@PathVariable(name = "id") Long reviewId, ReviewRequestDto reviewRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
       //작성자만 수정 button 볼 수 있으면 if문 삭제 예정
        if (userDetails != null) {
            reviewService.updateReview(reviewId, reviewRequestDto);
        } else {
            // 예외처리
        }
    }

    //리뷰 삭제
    @DeleteMapping("/hospital/reviews/{id}")
    public void deleteReview(@PathVariable(name = "id") Long reviewId, @AuthenticationPrincipal UserDetailsImpl userDetails ) {
        reviewService.deleteReview(reviewId);
    }
}

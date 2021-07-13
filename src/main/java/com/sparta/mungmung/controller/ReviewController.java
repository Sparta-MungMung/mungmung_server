package com.sparta.mungmung.controller;

import com.sparta.mungmung.domain.Review;
import com.sparta.mungmung.dto.ReviewPageResponseDto;
import com.sparta.mungmung.dto.ReviewRequestDto;
import com.sparta.mungmung.exception.ApiRequestException;
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
    @GetMapping("/hospitals/{id}/reviews")
    public ReviewPageResponseDto getReviewList(@PathVariable(name = "id") Long hospitalId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            Long userId = userDetails.getUser().getUserId();
            return reviewService.findReview(hospitalId, userId);
        }

        return reviewService.findReview(hospitalId);
    }

    //리뷰 작성
    @PostMapping("/hospitals/{id}/reviews")
    public void createReview(@PathVariable(name = "id") Long hospitalId,@RequestBody ReviewRequestDto reviewRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            Long userId = userDetails.getUser().getUserId();
            reviewService.saveReview(reviewRequestDto, hospitalId, userId);
        } else {
            throw new ApiRequestException("회원가입 후 리뷰 등록 가능합니다.");
        }
    }

    //리뷰 수정
    @PutMapping("/hospitals/reviews/{id}")
    public void updateReview(@PathVariable(name = "id") Long reviewId,@RequestBody ReviewRequestDto reviewRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
       //작성자만 수정 button 볼 수 있으면 if문 삭제 예정
        if (userDetails != null) {
            reviewService.updateReview(reviewId, reviewRequestDto);
        } else {
            throw new ApiRequestException("회원가입 후 리뷰 수정 가능합니다.");
        }
    }

    //리뷰 삭제
    @DeleteMapping("/hospitals/reviews/{id}")
    public void deleteReview(@PathVariable(name = "id") Long reviewId, @AuthenticationPrincipal UserDetailsImpl userDetails ) {
        reviewService.deleteReview(reviewId);
    }
}
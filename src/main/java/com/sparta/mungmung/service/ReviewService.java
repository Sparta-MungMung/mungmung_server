package com.sparta.mungmung.service;

import com.sparta.mungmung.domain.Hospital;
import com.sparta.mungmung.domain.Review;
import com.sparta.mungmung.dto.ReviewRequestDto;
import com.sparta.mungmung.repository.HospitalRepository;
import com.sparta.mungmung.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public List<Review> findReview(Long hospitalId) {
        return reviewRepository.findAllByHospitalId(hospitalId);
    }

    public void saveReview(ReviewRequestDto reviewRequestDto, Long hospitalId, Long userId) {
        reviewRequestDto.setHospitalId(hospitalId);
        reviewRequestDto.setUserId(userId);
        Review review = new Review(reviewRequestDto);
        reviewRepository.save(review);

        updateHospitalRate(hospitalId, reviewRequestDto.getReviewRate());
    }

    @Transactional
    public void updateReview(Long reviewId, ReviewRequestDto reviewRequestDto) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new NullPointerException("등록된 review 없음")
        );
        review.update(reviewRequestDto);

        //hospitalRate update 기능 구현 예정
        //updateHospitalRate(review.getHospitalId(), reviewRequestDto.getReviewRate());
    }

    @Transactional
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public void updateHospitalRate(Long hospitalId, Long reviewRate) {
        Hospital hospital = hospitalRepository.getById(hospitalId);
        List<Review> reviewList = reviewRepository.findAllByHospitalId(hospitalId);
        int reviewCount = reviewList.size();
        hospital.updateHospitalRate(reviewRate, reviewCount);
    }
}

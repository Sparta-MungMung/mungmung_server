package com.sparta.mungmung.dto;

import com.sparta.mungmung.domain.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReviewPageResponseDto {
    private Long userId;
    private List<Review> reviewList;
}

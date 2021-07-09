package com.sparta.mungmung.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
@NoArgsConstructor
public class ReviewRequestDto {

    private String reviewContent;
    private Long postId;
    private Long userId;

}

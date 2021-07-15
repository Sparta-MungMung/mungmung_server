package com.sparta.mungmung.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDto {

    private String reviewContent;
    private Long hospitalId;
    private Long userId;
    private Long hospitalRate;
    private String dogImage;
    private String dogName;

}

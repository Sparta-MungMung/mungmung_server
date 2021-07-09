package com.sparta.mungmung.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HospitalRequestDto {

    private String hospitalName;
    private String hospitalContent;
    private Float hospitalRate;
    private String hospitalLocation;
    private String hospitalNumber;
    private String hospitalImageSource;

}

package com.sparta.mungmung.controller;


import com.sparta.mungmung.service.SearchHospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubjectController {

    private final SearchHospitalService searchHospitalService;

    // 병원 검색
    @GetMapping("/hospitals/search")
    public void searchHospitals(@RequestParam String query){
    }


}

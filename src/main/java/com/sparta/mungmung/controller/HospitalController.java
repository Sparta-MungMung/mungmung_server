package com.sparta.mungmung.controller;

import com.sparta.mungmung.domain.Hospital;
import com.sparta.mungmung.repository.HospitalRepository;
import com.sparta.mungmung.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final HospitalRepository hospitalRepository;

    //병원 목록 조회
    @GetMapping("/hospitals")
    public List<Hospital> getHospitalList() {
        return hospitalRepository.findAll();
    }

    //병원 상세 조회
    @GetMapping("/hospitals/{id}")
    public Hospital getHospital(@PathVariable(name = "id") Long hospitalId) {
        return hospitalRepository.findById(hospitalId).get();
    }

    //병원 위치 조회
    @GetMapping("/hospitals/{id}/location")
    public String getHospitalLocation(@PathVariable(name = "id") Long hospitalId) {
        return hospitalService.findHospitalLocation(hospitalId);
    }

    //병원 검색 목록 조회
    @GetMapping("hospitals/search")
    public List<Hospital> getSearchedHospital(@RequestParam(name = "subject") String encodedSubjectName) throws UnsupportedEncodingException {
        String subjectName = URLDecoder.decode(encodedSubjectName, "UTF-8");
        if (hospitalService.findHospitalBySubjectName(subjectName) != null){
            return hospitalService.findHospitalBySubjectName(subjectName);
        } else {
            return hospitalRepository.findAll();
        }
    }
}

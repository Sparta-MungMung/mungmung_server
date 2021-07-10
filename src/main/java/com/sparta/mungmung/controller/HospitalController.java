package com.sparta.mungmung.controller;

import com.sparta.mungmung.domain.Hospital;
import com.sparta.mungmung.repository.HospitalRepository;
import com.sparta.mungmung.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final HospitalRepository hospitalRepository;

    @GetMapping("/hospitals")
    public List<Hospital> getHospitalList() {
        return hospitalRepository.findAll();
    }

    @GetMapping("/hospitals/{id}")
    public Hospital getHospital(@PathVariable(name = "id") Long hospitalId) {
        return hospitalRepository.getById(hospitalId);
    }

    @GetMapping("/hospitals/{id}/location")
    public String getHospitalLocation(@PathVariable(name = "id") Long hospitalId){
        return hospitalService.findHospitalLocation(hospitalId);
    }
}

package com.sparta.mungmung.service;

import com.sparta.mungmung.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public String findHospitalLocation(Long hospitalId){
        return hospitalRepository.getById(hospitalId).getHospitalLocation();
    }

}

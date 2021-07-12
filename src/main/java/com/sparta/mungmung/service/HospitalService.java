package com.sparta.mungmung.service;

import com.sparta.mungmung.domain.Hospital;
import com.sparta.mungmung.domain.Subject;
import com.sparta.mungmung.repository.HospitalRepository;
import com.sparta.mungmung.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final SubjectRepository subjectRepository;

    public String findHospitalLocation(Long hospitalId){
        return hospitalRepository.getById(hospitalId).getHospitalLocation();
    }

    public List<Hospital> findHospitalBySubjectName(String subjectName) {
        Optional<Subject> subject = subjectRepository.findBySubjectName(subjectName);
        if (subject.isPresent()) {
            List<Hospital> findHospitalList = hospitalRepository.findAllBySubject_list_subject_id(subject.get().getSubjectId());
            return findHospitalList;
        } else {
            return null;
        }


    }

}

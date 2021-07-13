package com.sparta.mungmung.repository;

import com.sparta.mungmung.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findAllBySubjectList_SubjectId(Long subjectId);
}

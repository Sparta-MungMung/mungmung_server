package com.sparta.mungmung.repository;


import com.sparta.mungmung.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.mungmung.domain.Hospital;
import com.sparta.mungmung.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySubjectName(String subjectName);
}

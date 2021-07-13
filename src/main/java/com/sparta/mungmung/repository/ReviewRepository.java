package com.sparta.mungmung.repository;

import com.sparta.mungmung.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
//    List<Review> findAllByHospitalId(Long hospitalId);
    List<Review> findAllByOrderByHospitalIdDesc(Long hospitalId);
}

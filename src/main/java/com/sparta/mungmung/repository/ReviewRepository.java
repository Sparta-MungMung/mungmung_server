package com.sparta.mungmung.repository;

import com.sparta.mungmung.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}

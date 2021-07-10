package com.sparta.mungmung.repository;

import com.sparta.mungmung.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findAllByUserId(Long userId);
}

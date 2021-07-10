package com.sparta.mungmung.repository;

import com.sparta.mungmung.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userid);
    Optional<User> findByUsername(String username);
}

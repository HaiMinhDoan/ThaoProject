package com.devthao.animecenter.repository;

import com.devthao.animecenter.models.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByUserEmail(String email);
    Optional<Token> findByUserId(Long userId);
}

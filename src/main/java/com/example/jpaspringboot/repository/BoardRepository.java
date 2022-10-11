package com.example.jpaspringboot.repository;

import com.example.jpaspringboot.domain.AuthCode;
import com.example.jpaspringboot.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByAuthCode(AuthCode authCode);
}

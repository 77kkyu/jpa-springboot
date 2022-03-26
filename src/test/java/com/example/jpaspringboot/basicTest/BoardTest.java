package com.example.jpaspringboot.basicTest;

import com.example.jpaspringboot.entity.Board;
import com.example.jpaspringboot.repository.BoardRepository;
import com.example.jpaspringboot.repository.querydsl.BoardRepositorySupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardRepositorySupport boardRepositorySupport;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public Board 게시판조회() {
        Board board = boardRepository.getById(3L);
        assertThat(board).isNotNull();
        return board;
    }

}

package com.example.jpaspringboot.basicTest;

import com.example.jpaspringboot.entity.AuthCode;
import com.example.jpaspringboot.entity.Board;
import com.example.jpaspringboot.repository.BoardRepository;
import com.example.jpaspringboot.repository.querydsl.BoardRepositorySupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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

    @Test
    public void enumTest() {
        boardRepository.save(Board.builder()
                .userId(1L)
                .title("title")
                .contents("content")
                .authCode(AuthCode.A)
                .build());
    }

    @Test
    public void enumFindTest() {
//        Optional<Board> board = boardRepository.findById(1L);
//        System.out.println(board.get().toString());

        List<Board> findEnum = boardRepository.findAllByAuthCode(AuthCode.A);
        findEnum.stream().forEach(e -> System.out.println("데이터 : " + e.toString()));

    }

}

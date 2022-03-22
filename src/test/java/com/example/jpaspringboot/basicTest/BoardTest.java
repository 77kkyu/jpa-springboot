package com.example.jpaspringboot.basicTest;

import com.example.jpaspringboot.repository.BoardRepository;
import com.example.jpaspringboot.repository.querydsl.BoardRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardRepositorySupport boardRepositorySupport;

    @Autowired
    private BoardRepository boardRepository;

}

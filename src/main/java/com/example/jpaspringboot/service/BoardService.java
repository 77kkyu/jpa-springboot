package com.example.jpaspringboot.service;

import com.example.jpaspringboot.repository.querydsl.BoardRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    
    private final BoardRepositorySupport boardRepositorySupport;
    
}

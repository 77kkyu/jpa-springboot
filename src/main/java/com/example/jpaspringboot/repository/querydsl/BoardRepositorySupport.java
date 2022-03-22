package com.example.jpaspringboot.repository.querydsl;

import com.example.jpaspringboot.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

}

package com.example.jpaspringboot.repository.querydsl;

import com.example.jpaspringboot.entity.Board;
import com.example.jpaspringboot.entity.Team;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.example.jpaspringboot.entity.QBoard.board;

@Repository
public class BoardRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public enum OrderByType {
        ASC{
            @Override
            public JPAQuery execute(JPAQuery jpaQuery) {
                return (JPAQuery) jpaQuery.orderBy(new OrderSpecifier<>(Order.ASC, Expressions.numberPath(Long.class, "")));
            }
        },
        ORDER{
            @Override
            public JPAQuery execute(JPAQuery jpaQuery) {
                return (JPAQuery) jpaQuery.orderBy(new OrderSpecifier<>(Order.DESC, board.id));
            }
        };

        public abstract JPAQuery execute(JPAQuery jpaQuery);
    }

}

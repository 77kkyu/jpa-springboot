package com.example.jpaspringboot.repository.querydsl;

import com.example.jpaspringboot.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jpaspringboot.entity.QTeam.team;

@Repository
public class TeamRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public TeamRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Team> findName(String name) {
        return jpaQueryFactory.selectFrom(team)
                .where(team.name.eq(name))
                .fetch();
    }

}
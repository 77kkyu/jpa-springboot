package com.example.jpaspringboot.repository.querydsl;

import com.example.jpaspringboot.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.jpaspringboot.entity.QTeam.team;
import static com.example.jpaspringboot.entity.QMember.member;

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

    public long updateTeam(String name, Long id) {
        return jpaQueryFactory.update(team)
                .set(team.name, name)
                .where(team.id.eq(id))
                .execute();
    }

    public Team findTeam(Long teamId) {
        return jpaQueryFactory.selectFrom(team)
                .where(team.id.eq(teamId))
                .fetchOne();
    }

    public long deleteTeam(Long teamId) {
        return jpaQueryFactory.delete(team)
                .where(team.id.eq(teamId))
                .execute();
    }

    public List<Team> findTeamOrderBy(String name) {
        return jpaQueryFactory.selectFrom(team)
                .where(team.name.eq(name))
                .orderBy(team.id.asc())
                .fetch();
    }

    public List<Team> joinTest() {
        return jpaQueryFactory.select(team)
                .join(member)
                .where(team.id.eq(3L), team.id.eq(member.team.id))
                .fetch();
    }


}

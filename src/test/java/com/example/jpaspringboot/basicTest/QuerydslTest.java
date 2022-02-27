package com.example.jpaspringboot.basicTest;

import com.example.jpaspringboot.entity.Team;
import com.example.jpaspringboot.repository.querydsl.TeamRepositorySupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class QuerydslTest {

    @Autowired
    private TeamRepositorySupport teamRepositorySupport;

    @Test
    public void Querydsl조회테스트() { // Querydsl 동작확인
        List<Team> teams = teamRepositorySupport.findName("devTeam");
        teams.forEach(e -> System.out.println("findName : "+e.getName()));
    }

    @Transactional
    @Test
    public void 업데이트() { // id조건으로 업데이트
        Long update = teamRepositorySupport.updateTeam("dev1", 3L);
        System.out.println(update);
    }

    @Transactional
    @Test
    public void id조회() { // 조회 및 하위 테이블 조회
        Team findTeam = teamRepositorySupport.findTeam(3L);
        System.out.println("findTeamName : " + findTeam.getName());
        findTeam.getMembers().stream()
                .forEach( e -> System.out.println("members userName : " + e.getUserName()));
    }

    @Test
    public void 삭제() { // id로 삭제
        Long deleteTeam = teamRepositorySupport.deleteTeam(3L);
    }

    @Test
    public void 조인() {
        List<Team> teams = teamRepositorySupport.joinTest();
        System.out.println("members1: " + teams.get(0).getMembers().get(0).getUserName());
        System.out.println("members2 : " + teams.get(0).getMembers().get(1).getUserName());
    }

    @Test
    public void 빌더테스트() {
        Team teams = teamRepositorySupport.findByTeam(3L);
        assertThat(teams.getId()).isNotNull();
        assertThat(teams.getName()).isEqualTo("dev1");
    }

}

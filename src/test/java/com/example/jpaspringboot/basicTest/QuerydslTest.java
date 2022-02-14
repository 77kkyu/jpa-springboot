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
    public void 업데이트() {
        Long update = teamRepositorySupport.updateTeam("dev1", 3L);
        System.out.println(update);
    }

}

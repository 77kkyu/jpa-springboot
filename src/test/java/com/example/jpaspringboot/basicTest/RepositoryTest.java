package com.example.jpaspringboot.basicTest;

import com.example.jpaspringboot.entity.Member;
import com.example.jpaspringboot.entity.Team;
import com.example.jpaspringboot.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void 등록테스트() {

        List<Member> memberList = new ArrayList<>();
        memberList.add(Member.builder().userName("77kkyu").build());
        memberList.add(Member.builder().userName("hash").build());
        Team team = Team.builder()
                .name("devTeam")
                .members(memberList)
                .build();

        Team save = teamRepository.save(team);
        assertThat(save.getId()).isNotNull();
        assertThat(save.getName()).isEqualTo("devTeam");

    }

    @Test
    public void 조회테스트() {

        Optional<Team> team = teamRepository.findById(3L);
        System.out.println("getName : " + team.get().getName());

    }

}

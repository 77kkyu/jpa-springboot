package com.example.jpaspringboot.basicTest;

import com.example.jpaspringboot.domain.Member;
import com.example.jpaspringboot.domain.Team;
import com.example.jpaspringboot.repository.TeamRepository;
import com.example.jpaspringboot.response.ResponseMessage;
import com.example.jpaspringboot.service.TeamService;
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

    @Autowired
    private TeamService teamService;

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

    @Test
    public void 팀조회테스트() {
        ResponseMessage responseMessage = teamService.getTeam(3L);
        assertThat(responseMessage.getMessage()).isNotNull();
        assertThat(responseMessage.getStatus()).isEqualTo(200);
        System.out.println("responseMessage : " + responseMessage.getMessage());
        System.out.println("teamDto : " + responseMessage.getData().toString());

    }

}

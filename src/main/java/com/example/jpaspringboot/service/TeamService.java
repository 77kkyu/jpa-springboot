package com.example.jpaspringboot.service;

import com.example.jpaspringboot.entity.Team;
import com.example.jpaspringboot.repository.querydsl.TeamRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepositorySupport teamRepositorySupport;

    public Team getTeam(Long id) {
        Team team = teamRepositorySupport.findTeam(id);
        Optional<Team> optionalTeam = Optional.ofNullable(teamRepositorySupport.findTeam(id));
        if (optionalTeam.isPresent()) {
            return team;
        }else { // 에러 처리 해야함
            return team;
        }
    }

}

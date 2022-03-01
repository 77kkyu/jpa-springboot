package com.example.jpaspringboot.service;

import com.example.jpaspringboot.entity.Team;
import com.example.jpaspringboot.repository.querydsl.TeamRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepositorySupport teamRepositorySupport;

    public Team getTeam(Long id) {
        Team team = teamRepositorySupport.findTeam(id);
        return team;
    }

}

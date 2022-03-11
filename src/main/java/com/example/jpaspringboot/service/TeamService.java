package com.example.jpaspringboot.service;

import com.example.jpaspringboot.dto.TeamDto;
import com.example.jpaspringboot.entity.Team;
import com.example.jpaspringboot.repository.querydsl.TeamRepositorySupport;
import com.example.jpaspringboot.response.ResponseMessage;
import com.example.jpaspringboot.response.ResultCodeSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepositorySupport teamRepositorySupport;

    public ResponseMessage getTeam(Long id) {
        Team team = teamRepositorySupport.findTeam(id);
        Optional<Team> optionalTeam = Optional.ofNullable(teamRepositorySupport.findTeam(id));
        if (optionalTeam.isPresent()) {
            TeamDto teamDto = TeamDto.builder()
                    .id(optionalTeam.get().getId())
                    .name(optionalTeam.get().getName())
                    .build();
            return new ResponseMessage(ResultCodeSet.SUCCESS_COMMON, teamDto);
        }else { // 에러 처리 해야함
            return new ResponseMessage(ResultCodeSet.FAIL, team);
        }
    }

}

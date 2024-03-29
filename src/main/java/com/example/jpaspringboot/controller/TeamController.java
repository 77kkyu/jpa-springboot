package com.example.jpaspringboot.controller;

import com.example.jpaspringboot.response.ResponseMessage;
import com.example.jpaspringboot.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/test/getTeam")
    public ResponseMessage getTeam(Long id) {
        return teamService.getTeam(id);
    }

}

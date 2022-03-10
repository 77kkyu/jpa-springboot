package com.example.jpaspringboot.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {

    private Long id;

    private String name;

    private List<MemberDto> members = new ArrayList<>();

}

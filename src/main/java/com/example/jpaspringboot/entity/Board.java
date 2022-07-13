package com.example.jpaspringboot.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    private String title;

    private String contents;

    @Column(name = "AUTH_CODE")
    @Enumerated(EnumType.STRING)
    private AuthCode authCode;

}

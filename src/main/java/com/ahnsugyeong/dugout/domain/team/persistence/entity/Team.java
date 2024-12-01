package com.ahnsugyeong.dugout.domain.team.persistence.entity;

import com.ahnsugyeong.dugout.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Team extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TeamName name;

    @Embedded
    private TeamColor color;

    private String stadiumName;

}

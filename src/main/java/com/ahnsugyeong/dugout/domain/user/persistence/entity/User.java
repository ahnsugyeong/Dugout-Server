package com.ahnsugyeong.dugout.domain.user.persistence.entity;

import com.ahnsugyeong.dugout.domain.team.persistence.entity.Team;
import com.ahnsugyeong.dugout.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}

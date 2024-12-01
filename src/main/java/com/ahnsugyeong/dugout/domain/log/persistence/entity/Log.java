package com.ahnsugyeong.dugout.domain.log.persistence.entity;

import com.ahnsugyeong.dugout.domain.game.persistence.entity.Game;
import com.ahnsugyeong.dugout.domain.user.persistence.entity.User;
import com.ahnsugyeong.dugout.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Log extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String imageUrl;

    private String content;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

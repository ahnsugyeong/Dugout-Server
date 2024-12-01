package com.ahnsugyeong.dugout.domain.team.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class TeamColor {

    private String primaryColor;
    private String secondaryColor;
    private String tertiaryColor;

}

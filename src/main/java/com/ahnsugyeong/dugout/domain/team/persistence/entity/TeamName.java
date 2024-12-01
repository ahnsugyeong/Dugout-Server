package com.ahnsugyeong.dugout.domain.team.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class TeamName {

    private String englishPrefix;
    private String englishSuffix;
    private String koreanPrefix;
    private String koreanSuffix;

}

package com.ahnsugyeong.dugout.domain.team.persistence.dao;

import com.ahnsugyeong.dugout.domain.team.persistence.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}

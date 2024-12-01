package com.ahnsugyeong.dugout.domain.game.persistence.dao;

import com.ahnsugyeong.dugout.domain.game.persistence.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}

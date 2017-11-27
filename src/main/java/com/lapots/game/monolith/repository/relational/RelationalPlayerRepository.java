package com.lapots.game.monolith.repository.relational;

import com.lapots.game.monolith.domain.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationalPlayerRepository extends JpaRepository<Player, Long> {
}
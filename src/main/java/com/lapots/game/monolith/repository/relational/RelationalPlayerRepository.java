package com.lapots.game.monolith.repository.relational;

import com.lapots.game.monolith.domain.player.relational.RPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationalPlayerRepository extends JpaRepository<RPlayer, Long> {
    RPlayer findByName(String name);
}

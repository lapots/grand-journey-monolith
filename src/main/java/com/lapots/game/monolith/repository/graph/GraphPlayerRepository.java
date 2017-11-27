package com.lapots.game.monolith.repository.graph;

import com.lapots.game.monolith.domain.player.Player;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface GraphPlayerRepository extends GraphRepository<Player> {
    Player findByName(String name);
}

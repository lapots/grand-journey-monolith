package com.lapots.game.monolith.repository.graph;

import com.lapots.game.monolith.domain.player.graph.GPlayer;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface GraphPlayerRepository extends GraphRepository<GPlayer> {
    List<GPlayer> findAll();
    GPlayer findByName(String name);
}

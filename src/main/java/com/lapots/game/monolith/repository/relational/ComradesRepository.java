package com.lapots.game.monolith.repository.relational;

import com.lapots.game.monolith.domain.player.relational.Comrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ComradesRepository extends JpaRepository<Comrade, String> {
    Set<Comrade> findByKeysPlayer(String player);
}

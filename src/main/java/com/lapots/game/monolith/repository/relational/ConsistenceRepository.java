package com.lapots.game.monolith.repository.relational;

import com.lapots.game.monolith.domain.player.Consistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsistenceRepository extends JpaRepository<Consistence, Consistence.Mapping> {
}

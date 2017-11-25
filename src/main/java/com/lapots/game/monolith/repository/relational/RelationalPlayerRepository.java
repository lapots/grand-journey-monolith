package com.lapots.game.monolith.repository.relational;

import com.lapots.game.monolith.domain.player.Player;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RelationalPlayerRepository extends PagingAndSortingRepository<Player, Long> {
}

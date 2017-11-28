package com.lapots.game.monolith.service.api;

import com.lapots.game.monolith.util.domain.IdPair;

public interface IPlayerService {
    boolean checkPlayer(String playerName);

    IdPair createNewPlayer(String playerName, String playerClass);

    void connectPlayers(String toWhom, String whom);
}

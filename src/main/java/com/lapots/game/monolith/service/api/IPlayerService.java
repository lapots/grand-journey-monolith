package com.lapots.game.monolith.service.api;

import java.util.Set;

public interface IPlayerService {
    boolean checkPlayer(String playerName);

    String createNewPlayer(String playerName, String playerClass);

    void connectPlayers(String toWhom, String whom);

    Set<String> findCombrades(String player);
}

package com.lapots.game.monolith.service;

import com.lapots.game.monolith.domain.player.relational.Comrade;
import com.lapots.game.monolith.domain.player.relational.Player;
import com.lapots.game.monolith.repository.relational.ComradesRepository;
import com.lapots.game.monolith.repository.relational.RelationalPlayerRepository;
import com.lapots.game.monolith.service.api.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService implements IPlayerService {

    @Autowired
    private RelationalPlayerRepository rRepo;

    @Autowired
    private ComradesRepository rCombradesRepo;

    @Override
    public boolean checkPlayer(String playerName) {
        return rRepo.findOne(playerName) != null;
    }

    @Override
    public String createNewPlayer(String playerName, String playerClass) {
        Player rPlayer = rRepo.findOne(playerName);
        if (null == rPlayer) {
            rPlayer = new Player();
            rPlayer.setClazz(playerClass);
            rPlayer.setLevel(0);
            rPlayer.setName(playerName);
            rRepo.save(rPlayer);
        }
        return playerName;
    }

    @Override
    public void connectPlayers(String toWhom, String whom) {
        if (!rCombradesRepo.findByKeysPlayer(toWhom).contains(whom)) {
            rCombradesRepo.save(new Comrade().makeComrades(toWhom, whom));
        }
    }

    @Override
    public Set<String> findCombrades(String player) {
        return rCombradesRepo.findByKeysPlayer(player)
                .stream()
                .map(Comrade::getComrade)
                .collect(Collectors.toSet());
    }
}

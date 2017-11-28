package com.lapots.game.monolith.service;

import com.lapots.game.monolith.domain.player.graph.GPlayer;
import com.lapots.game.monolith.domain.player.relational.RPlayer;
import com.lapots.game.monolith.repository.graph.GraphPlayerRepository;
import com.lapots.game.monolith.repository.relational.RelationalPlayerRepository;
import com.lapots.game.monolith.service.api.IPlayerService;
import com.lapots.game.monolith.util.DomainUtils;
import com.lapots.game.monolith.util.domain.IdPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class PlayerService implements IPlayerService {

    @Autowired
    private RelationalPlayerRepository rRepo;

    @Autowired
    private GraphPlayerRepository gRepo;

    @Override
    public boolean checkPlayer(String playerName) {
        return rRepo.findByName(playerName) == null;
    }

    @Override
    public IdPair createNewPlayer(String playerName, String playerClass) {
        RPlayer rPlayer = rRepo.findByName(playerName);
        if (null == rPlayer) {
            rPlayer = new RPlayer();
            rPlayer.setClazz(playerClass);
            rPlayer.setLevel(0);
            rPlayer.setName(playerName);
            UUID rId = rRepo.save(rPlayer).getId();

            GPlayer player = gRepo.findByName(playerName);
            if (null == player) {
                player = new GPlayer();
                player.setName(playerName);
                player.setUuid(rId);
                Long gId = gRepo.save(player).getId();
                return DomainUtils.createIdPair(gId, rId);
            } else {
                // TODO: should not be possible at that stage
                // inconsistency. critical error!
                return null;
            }
        } else {
            // TODO: player exist
            return null;
        }
    }

    @Override
    public void connectPlayers(String toWhom, String whom) {
        GPlayer player = gRepo.findByName(toWhom);
        if (null == player) {
            return; // TODO: implement bad flow
        }

        GPlayer toAc = gRepo.findByName(whom);
        if (null == toAc) {
            return; // TODO: implement bad flow
        }

        player.acquainted(toAc);
        gRepo.save(player);
    }
}

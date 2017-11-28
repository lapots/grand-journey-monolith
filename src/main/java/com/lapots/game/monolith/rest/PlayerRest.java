package com.lapots.game.monolith.rest;

import com.lapots.game.monolith.domain.player.graph.GPlayer;
import com.lapots.game.monolith.domain.player.relational.RPlayer;
import com.lapots.game.monolith.repository.graph.GraphPlayerRepository;
import com.lapots.game.monolith.repository.relational.RelationalPlayerRepository;
import com.lapots.game.monolith.rest.out.CompletePlayer;
import com.lapots.game.monolith.util.DomainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerRest {

    @Autowired
    private GraphPlayerRepository gPlayerRepo;

    @Autowired
    private RelationalPlayerRepository rPlayerRepo;

    @GetMapping("/grand-journey/players/all")
    public List<CompletePlayer> findPlayers() {
        List<GPlayer> gPlayers = gPlayerRepo.findAll();
        List<RPlayer> rPlayers = rPlayerRepo.findAll();
        List<CompletePlayer> players = new ArrayList<>();
        for (GPlayer gPlayer : gPlayers) {
            for (RPlayer rPlayer : rPlayers) {
                if (gPlayer.getUuid() == rPlayer.getId()) {
                    players.add(DomainUtils.merge(rPlayer, gPlayer));
                }
            }
        }
        return players;
    }

}

package com.lapots.game.monolith.rest;

import com.lapots.game.monolith.domain.player.relational.Player;
import com.lapots.game.monolith.repository.relational.RelationalPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerRest {

    @Autowired
    private RelationalPlayerRepository rPlayerRepo;

    @GetMapping("/grand-journey/players/all")
    public List<Player> findPlayers() {
        return rPlayerRepo.findAll();
    }

}

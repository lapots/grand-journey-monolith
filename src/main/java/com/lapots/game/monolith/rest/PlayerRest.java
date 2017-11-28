package com.lapots.game.monolith.rest;

import com.lapots.game.monolith.repository.graph.GraphPlayerRepository;
import com.lapots.game.monolith.repository.relational.ConsistenceRepository;
import com.lapots.game.monolith.repository.relational.RelationalPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerRest {

    @Autowired
    private GraphPlayerRepository gPlayerRepo;

    @Autowired
    private RelationalPlayerRepository rPlayerRepo;

    @Autowired
    private ConsistenceRepository cRepo;

    @GetMapping("/grand-journey/players/all")
    public List<String> findPlayers() {
        gPlayerRepo.findAll();
        rPlayerRepo.findAll();
        // for each player using Consistence object find matching ids and merge
        // DomainUtils.merge(rPlayer, gPlayer);
        return null;
    }

}

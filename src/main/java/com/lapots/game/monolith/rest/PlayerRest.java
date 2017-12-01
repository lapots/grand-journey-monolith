package com.lapots.game.monolith.rest;

import com.lapots.game.monolith.domain.player.relational.Player;
import com.lapots.game.monolith.repository.relational.RelationalPlayerRepository;
import com.lapots.game.monolith.rest.dto.PageableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerRest {

    @Autowired
    private RelationalPlayerRepository rPlayerRepo;

    @GetMapping("/grand-journey/players/all")
    public PageableResponse<List<Player>> findPlayers(@RequestParam int limit, @RequestParam int offset) {
        Page<Player> content = rPlayerRepo.findAll(new PageRequest(offset, limit));

        PageableResponse<List<Player>> pageableResponse = new PageableResponse<>();
        pageableResponse.setLimit(limit);
        pageableResponse.setOffset(offset);
        pageableResponse.setContent(content.getContent());
        pageableResponse.setPageCount(content.getTotalPages());

        return pageableResponse;
    }
}

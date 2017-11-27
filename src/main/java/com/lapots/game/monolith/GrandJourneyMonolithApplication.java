package com.lapots.game.monolith;

import com.lapots.game.monolith.test.repository.relational.RelationalPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrandJourneyMonolithApplication {

    @Autowired
    private RelationalPlayerRepository relationalPlayerRepository;

    public static void main(String[] args) {
        SpringApplication.run(GrandJourneyMonolithApplication.class, args);
    }
}

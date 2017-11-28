package com.lapots.game.monolith;

import com.lapots.game.monolith.service.api.IPlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class GrandJourneyMonolithApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(GrandJourneyMonolithApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GrandJourneyMonolithApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(IPlayerService playerService) {
        return args -> {
            String playerName = "MagusX";
            LOGGER.info("Is exist [{}] player? {}", playerName, playerService.checkPlayer(playerName));
            playerService.createNewPlayer("MagusX", "magician");
            LOGGER.info("Is exist [{}] player?", playerName, playerService.checkPlayer(playerName));
        };
    }

}

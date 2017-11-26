package com.lapots.game.monolith;

import com.lapots.game.monolith.domain.player.Player;
import com.lapots.game.monolith.test.repository.relational.RelationalPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrandJourneyMonolithApplication {

    @Autowired
    private RelationalPlayerRepository relationalPlayerRepository;

    public static void main(String[] args) {
        SpringApplication.run(GrandJourneyMonolithApplication.class, args);
    }

    @Bean
    public CommandLineRunner initPlayers() {
        return (args) -> {
            Player p = new Player();
            p.setLevel(10);
            p.setName("Master1909");
            p.setClazz("warrior");

            relationalPlayerRepository.save(p);
        };
    }
}
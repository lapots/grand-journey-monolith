package com.lapots.game.monolith;

import com.lapots.game.monolith.domain.player.Player;
import com.lapots.game.monolith.repository.graph.GraphPlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrandJourneyMonolithApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrandJourneyMonolithApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(GraphPlayerRepository graphRepository) {
        return args -> {
            Player p1 = new Player();
            p1.setLevel(10);
            p1.setName("Magus");
            p1.setClazz("magician");

            Player p2 = new Player();
            p2.setLevel(20);
            p2.setName("Hero");
            p2.setClazz("warrior");

            p1.acquainted(p2);

            graphRepository.save(p1);
            graphRepository.save(p2);

            System.out.println("Player information: " + graphRepository.findByName("Magus"));
        };
    }
}

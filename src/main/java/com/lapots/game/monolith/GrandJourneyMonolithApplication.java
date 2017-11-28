package com.lapots.game.monolith;

import com.lapots.game.monolith.domain.player.Consistence;
import com.lapots.game.monolith.domain.player.graph.GPlayer;
import com.lapots.game.monolith.domain.player.relational.RPlayer;
import com.lapots.game.monolith.repository.graph.GraphPlayerRepository;
import com.lapots.game.monolith.repository.relational.ConsistenceRepository;
import com.lapots.game.monolith.repository.relational.RelationalPlayerRepository;
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
    public CommandLineRunner init(GraphPlayerRepository gRepo,
                                  RelationalPlayerRepository rRepo,
                                  ConsistenceRepository consistenceRepo) {
        return args -> {
            LOGGER.info("Autowires: graph: {}, relational-player: {}, relational-cons: {}", gRepo, rRepo,
                    consistenceRepo);

            String playerName = "Magus20";
            Long gId = createPlayer(playerName, "Magus15", gRepo);
            UUID rId = createPlayer(playerName, rRepo);

            Consistence cn = new Consistence(new Consistence.Mapping(gId, rId));
            consistenceRepo.save(cn);

        };
    }

    private Long createPlayer(String playerName, String comrade, GraphPlayerRepository gRepo) {
        GPlayer gPlayer = gRepo.findByName(playerName);
        if (null == gPlayer) {
            gPlayer = new GPlayer();
            gPlayer.setName(playerName);
            if (null != comrade) {
                gPlayer.acquainted(gRepo.findByName(comrade));
            }
            gRepo.save(gPlayer);
            LOGGER.info("Created new GRAPH player: {}", gPlayer);
        } else {
            gPlayer.acquainted(gRepo.findByName(comrade));
            gRepo.save(gPlayer);
            LOGGER.info("Updated player: {}", gPlayer);
        }
        return gPlayer.getId();
    }

    private UUID createPlayer(String playerName, RelationalPlayerRepository rRepo) {
        RPlayer rPlayer = rRepo.findByName(playerName);
        if (null == rPlayer) {
            rPlayer = new RPlayer();
            rPlayer.setName(playerName);
            rPlayer.setClazz("magician");
            rPlayer.setLevel(20);
            rRepo.save(rPlayer);
            LOGGER.info("Created new RDBMS player: {}", rPlayer);
        }
        return rPlayer.getId();
    }
}

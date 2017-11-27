package com.lapots.game.monolith.test.repository.relational;

import com.lapots.game.monolith.GrandJourneyMonolithApplication;
import com.lapots.game.monolith.domain.player.Player;
import com.lapots.game.monolith.test.TestDBConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Sample test for repository.
 * As I don't have custom methods in JPA repository interface it's not needed.
 */
@RunWith(SpringRunner.class)
//@DataJpaTest TODO: resolve
@ContextConfiguration(classes = {TestDBConfig.class, GrandJourneyMonolithApplication.class})
public class RelationalPlayerRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RelationalPlayerRepository repository;

    @Test
    public void testBasic() {
        Player expected = createPlayer("Master12", "warrior", 10);
        this.entityManager.merge(expected);
        List<Player> players = repository.findAll();
        assertThat(repository.findAll()).isNotEmpty();
        assertEquals(expected, players.get(0));
    }

    private Player createPlayer(String name, String clazz, int level) {
        Player p = new Player();
        p.setId(1L);
        p.setName(name);
        p.setClazz(clazz);
        p.setLevel(level);
        return p;
    }
}

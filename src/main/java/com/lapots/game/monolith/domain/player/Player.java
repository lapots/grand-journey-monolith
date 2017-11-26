package com.lapots.game.monolith.domain.player;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(schema = "app", name = "players")
public class Player {
    @Id
    @GeneratedValue
    private Long id;

    @Transient
    Set<Player> comrades;

    @Column(unique = true)
    private String name;

    private int level;

    @Column(name = "class")
    private String clazz;
}

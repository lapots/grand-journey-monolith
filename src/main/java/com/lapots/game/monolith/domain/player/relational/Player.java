package com.lapots.game.monolith.domain.player.relational;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "app", name = "players")
public class Player {
    @Id
    @Column(unique = true)
    private String name;
    private int level;
    @Column(name = "class")
    private String clazz;
}

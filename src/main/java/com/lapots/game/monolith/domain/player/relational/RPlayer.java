package com.lapots.game.monolith.domain.player.relational;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(schema = "app", name = "players")
public class RPlayer {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String name;
    private int level;
    @Column(name = "class")
    private String clazz;
}

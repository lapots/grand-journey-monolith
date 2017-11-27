package com.lapots.game.monolith.domain.player;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(schema = "app", name = "players")
@NodeEntity
public class Player {
    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "comrade", direction = Relationship.UNDIRECTED)
    @Transient
    Set<Player> comrades;

    @GraphId
    @Column(unique = true)
    private String name;

    private int level;

    @Column(name = "class")
    private String clazz;

    /**
     * Adds new comrade.
     *
     * @param comrade comrade
     */
    public void acquainted(Player comrade) {
        if (null == comrades) {
            comrades = new HashSet<>();
        }
        comrades.add(comrade);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}

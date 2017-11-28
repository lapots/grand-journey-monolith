package com.lapots.game.monolith.domain.player.graph;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@Data
@NodeEntity
public class GPlayer {

    @GraphId
    private Long id;
    @Relationship(type = "comrade", direction = Relationship.UNDIRECTED)
    private Set<GPlayer> comrades;
    // @Indexed(unique = true) doesn't work in v4
    private String name;

    /**
     * Adds new comrade.
     *
     * @param comrade comrade
     */
    public void acquainted(GPlayer comrade) {
        if (null == comrades) {
            comrades = new HashSet<>();
        } else {
            if (comrades.contains(comrade)) {
                return;
            }
        }
        comrades.add(comrade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GPlayer gPlayer = (GPlayer) o;

        if (!id.equals(gPlayer.id)) return false;
        return name.equals(gPlayer.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GPlayer{" +
                "id=" + id +
                ", comrades=" + comrades +
                ", name='" + name + '\'' +
                '}';
    }
}

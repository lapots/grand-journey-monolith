package com.lapots.game.monolith.domain.player.relational;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(schema = "app", name = "friends")
@NoArgsConstructor
@AllArgsConstructor
public class Comrade {
    @EmbeddedId
    private ComradePair keys;

    public String getPlayer() {
        return keys.player;
    }

    public String getComrade() {
        return keys.comrade;
    }

    public Comrade makeComrades(String player, String comrade) {
        keys = new ComradePair();
        keys.player = player;
        keys.comrade = comrade;
        return this;
    }

    @Data
    @Embeddable
    private static class ComradePair implements Serializable {
        private String player;
        private String comrade;
    }
}

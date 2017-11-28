package com.lapots.game.monolith.domain.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "util", name = "mapping")
public class Consistence {
    @EmbeddedId
    private Mapping id;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class Mapping implements Serializable {
        @Column(name = "graph_id", nullable = false)
        private Long id;
        @Column(name = "relational_uuid", nullable = false)
        private UUID uuid;
    }
}

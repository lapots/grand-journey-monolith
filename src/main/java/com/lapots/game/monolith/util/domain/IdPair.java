package com.lapots.game.monolith.util.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class IdPair {
    private Long graphId;
    private UUID rId;
}

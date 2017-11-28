package com.lapots.game.monolith.rest.out;

import lombok.Data;

@Data
public class CompletePlayer {
    private String dataId;
    private String connectionId;
    private String name;
    private int level;
    private String clazz;
}

package com.lapots.game.monolith.rest.out;

import lombok.Data;

import java.util.List;

@Data
public class CompletePlayer {
    private String dataId;
    private String socialId;
    private String name;
    private int level;
    private String clazz;
    private List<BasicPlayer> comrades;
}

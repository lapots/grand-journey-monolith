package com.lapots.game.monolith.rest.out;

import com.lapots.game.monolith.domain.player.relational.RPlayer;
import com.lapots.game.monolith.domain.player.graph.GPlayer;

import java.util.stream.Collectors;

public class DomainUtils {

    public static CompletePlayer merge(RPlayer rData, GPlayer gData) {
        CompletePlayer cp = new CompletePlayer();
        cp.setClazz(rData.getClazz());
        cp.setDataId(rData.getId().toString());
        cp.setSocialId(gData.getId().toString());
        cp.setLevel(rData.getLevel());
        cp.setName(rData.getName());

        cp.setComrades(
            gData.getComrades().stream()
                    .map(comrade -> {
                        BasicPlayer bp = new BasicPlayer();
                        bp.setId(comrade.getId().toString());
                        bp.setName(comrade.getName());
                        return bp; })
                    .collect(Collectors.toList())
        );
        return cp;
    }

}

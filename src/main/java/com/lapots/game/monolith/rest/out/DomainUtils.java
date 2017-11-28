package com.lapots.game.monolith.rest.out;

import com.lapots.game.monolith.domain.player.relational.RPlayer;
import com.lapots.game.monolith.domain.player.graph.GPlayer;

public class DomainUtils {

    public static CompletePlayer merge(RPlayer rData, GPlayer gData) {
        CompletePlayer cp = new CompletePlayer();
        cp.setClazz(rData.getClazz());
        cp.setDataId(rData.getId().toString());
        cp.setConnectionId(gData.getId().toString());
        cp.setLevel(rData.getLevel());
        cp.setName(rData.getName());
        return cp;
    }

}

package com.lapots.game.monolith.util;

import com.lapots.game.monolith.domain.player.relational.RPlayer;
import com.lapots.game.monolith.domain.player.graph.GPlayer;
import com.lapots.game.monolith.rest.out.BasicPlayer;
import com.lapots.game.monolith.rest.out.CompletePlayer;
import com.lapots.game.monolith.util.domain.IdPair;
import lombok.experimental.UtilityClass;

import java.util.UUID;
import java.util.stream.Collectors;

@UtilityClass
public class DomainUtils {

    public CompletePlayer merge(RPlayer rData, GPlayer gData) {
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

    public IdPair createIdPair(Long gId, UUID rId) {
        IdPair ip = new IdPair();
        ip.setGraphId(gId);
        ip.setRId(rId);
        return ip;
    }

}

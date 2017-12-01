package com.lapots.game.monolith.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageableResponse<T extends List> {
    private int limit;
    private int offset;
    private int pageCount;
    private T content;
}

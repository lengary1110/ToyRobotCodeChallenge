package com.iress.code.model;

import lombok.Getter;

@Getter
public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction turn(Turn where) {
        return values()[(where == Turn.LEFT ?
                this.ordinal() + values().length - 1 :
                this.ordinal() + 1) % values().length];
    }
}

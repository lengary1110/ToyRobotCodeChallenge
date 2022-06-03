package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.iress.code.utils.ToyRobotConstants.*;

@Getter
@AllArgsConstructor
public class Position {
    private final int x;

    private final int y;

    public boolean checkPositionHazard() {
        return x < minX || (x > maxX || y < minY || y > maxY);
    }

    public Position move(Position offset) {
        return new Position(x + offset.getX(), y + offset.getY());
    }
}

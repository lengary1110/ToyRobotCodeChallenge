package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.iress.code.utils.ToyRobotConstants.*;
import static com.iress.code.utils.ToyRobotConstants.COMMA_REGX;

@Data
@AllArgsConstructor
public class Position {
    private int x;

    private int y;

    private Direction direction;

    public boolean checkPositionHazard() {
        return x < minX || (x > maxX || y < minY || y > maxY);
    }

    public String checkStatus() {
        return x + COMMA_REGX + y + COMMA_REGX + direction;
    }
}

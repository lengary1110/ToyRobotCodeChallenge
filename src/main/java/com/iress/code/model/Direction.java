package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.iress.code.utils.ToyRobotConstants.*;

@Getter
@AllArgsConstructor
public enum Direction {
    NORTH(NORTH_NAME),
    EAST(EAST_NAME),
    SOUTH(SOUTH_NAME),
    WEST(WEST_NAME);
    private final String directionName;
}

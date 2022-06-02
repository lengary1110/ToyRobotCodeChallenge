package com.iress.code.model;

import com.iress.code.exception.ToyRobotException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Getter
@Slf4j
public class Robot {

    private final Map<Direction, int[]> directionOffsetMap = Map.of(
            Direction.NORTH, new int[]{0, 1},
            Direction.EAST, new int[]{1, 0},
            Direction.SOUTH, new int[]{0, -1},
            Direction.WEST, new int[]{-1, 0}
    );
    private Position position;

    public Robot(Position position) {
        if (position.checkPositionHazard()) {
            throw new ToyRobotException("This Robot cannot be placed on the table");
        }
        this.position = position;
    }

    public void move() {
        Position newPosition = new Position(
                position.getX() + directionOffsetMap.get(position.getDirection())[0],
                position.getY() + directionOffsetMap.get(position.getDirection())[1],
                position.getDirection());
        if (newPosition.checkPositionHazard()) {
            log.warn("Prohibition: hazardous move to {}, {}", position.getX(), position.getY());
        } else {
            position = newPosition;
        }
    }

    public void leftRotate() {
        position.setDirection(position.getDirection().turn(Turn.LEFT));
    }

    public void rightRotate() {
        position.setDirection(position.getDirection().turn(Turn.RIGHT));
    }
}

package com.iress.code.model;

import com.iress.code.exception.ToyRobotException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static com.iress.code.utils.ToyRobotConstants.COMMA_REGX;

@Getter
@Slf4j
public class Robot {
    private final Map<Direction, Position> directionOffsetMap = Map.of(
            Direction.NORTH, new Position(0, 1),
            Direction.EAST, new Position(1, 0),
            Direction.SOUTH, new Position(0, -1),
            Direction.WEST, new Position(-1, 0)
    );
    private Position position;

    private Direction direction;

    public Robot(Position position, Direction direction) {
        if (position.checkPositionHazard()) {
            throw new ToyRobotException("This Robot cannot be placed on the table");
        }
        this.position = position;
        this.direction = direction;
    }

    public void move() {
        Position newPosition = position.move(directionOffsetMap.get(direction));
        if (newPosition.checkPositionHazard()) {
            log.warn("Prohibition: hazardous move to {}, {}", position.getX(), position.getY());
            return;
        }
        position = newPosition;
    }

    public void leftRotate() {
        direction = direction.turn(Turn.LEFT);
    }

    public void rightRotate() {
        direction = direction.turn(Turn.RIGHT);
    }

    @Override
    public String toString() {
        return position.getX() + COMMA_REGX + position.getY()
                + COMMA_REGX + direction.toString();
    }
}

package com.iress.code.model;

import com.iress.code.exception.ToyRobotException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static com.iress.code.utils.ToyRobotConstants.*;

@Getter
@Slf4j
public class Robot {

    private final Map<Direction, int[]> directionMap = Map.of(
            Direction.NORTH, new int[]{0, 1},
            Direction.EAST, new int[]{1, 0},
            Direction.SOUTH, new int[]{0, -1},
            Direction.WEST, new int[]{-1, 0}
    );
    private int x;
    private int y;
    private Direction direction;


    public Robot(int x, int y, Direction direction) {
        if (checkPositionHazard(x, y)) {
            throw new ToyRobotException("This Robot cannot be placed on the table");
        }
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public void move() {
        x = x + directionMap.get(direction)[0];
        y = y + directionMap.get(direction)[1];
    }

    public void leftRotate() {
        direction = direction.turn(Turn.LEFT);
    }

    public void rightRotate() {
        direction = direction.turn(Turn.RIGHT);
    }

    private boolean checkPositionHazard(int x, int y) {
        return x < minX || (x > maxX || y < minY || y > maxY);
    }

    public String checkStatus() {
        return x + COMMA_REGX + y + COMMA_REGX + direction;
    }
}

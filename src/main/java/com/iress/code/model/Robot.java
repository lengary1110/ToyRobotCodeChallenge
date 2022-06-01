package com.iress.code.model;

import com.iress.code.exception.ToyRobotException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Slf4j
public class Robot {
    @Value("${minX}")
    private int minX;
    @Value("${minY}")
    private int minY;
    @Value("${maxX}")
    public int maxX;
    @Value("${maxY}")
    public int maxY;
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        if (checkPositionHazard(x, y)) {
            throw new ToyRobotException("This Robot is not on the table");
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move() {
        switch (direction) {
            case NORTH:
                y++;
                if (checkPositionHazard(x, y)) {
                    y--;
                    warn(x, y);
                }
                break;
            case SOUTH:
                y--;
                if (checkPositionHazard(x, y)) {
                    y++;
                    warn(x, y);
                }
                break;
            case EAST:
                x++;
                if (checkPositionHazard(x, y)) {
                    x--;
                    warn(x, y);
                }
                break;
            case WEST:
                x--;
                if (checkPositionHazard(x, y)) {
                    x++;
                    warn(x, y);
                }
                break;
        }
    }

    private void warn(int x, int y) {
        log.warn("Hazard: return to " + x + ", " + y);
    }

    private boolean checkPositionHazard(int x, int y) {
        return x < minX || (x > maxX || y < minY || y > maxY);
    }

    public void leftRotate() {
        direction = direction.turn(Turn.LEFT);
    }

    public void rightRotate() {
        direction = direction.turn(Turn.RIGHT);
    }

    public String checkStatus() {
        return x + "," + y + "," + direction;
    }
}

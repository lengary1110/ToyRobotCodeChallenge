package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Robot {
    private int x;
    private int y;
    private Direction direction;
    // TODO: try better writing ways
    public void move() {
        switch (direction) {
            case NORTH:
                y++;
                if (checkPositionHazard(x, y)) {
                    y--;
                    log.warn("Hazard: return to " + x + ", " + y);
                }
                break;
            case SOUTH:
                y--;
                if (checkPositionHazard(x, y)) {
                    y++;
                    log.warn("Hazard: return to " + x + ", " + y);
                }
                break;
            case EAST:
                x++;
                if (checkPositionHazard(x, y)) {
                    x--;
                    log.warn("Hazard: return to " + x + ", " + y);
                }
                break;
            case WEST:
                x--;
                if (checkPositionHazard(x ,y)) {
                    x++;
                    log.warn("Hazard: return to " + x + ", " + y);
                }
                break;
        }
    }
    // TODO: extract
    private boolean checkPositionHazard(int x, int y) {
        return x < 0 || (x > 5 || y < 0 || y > 5);
    }
    public void leftRotate() {
        direction = direction.turn(Turn.LEFT);
    }

    public void rightRotate() {
        direction = direction.turn(Turn.RIGHT);
    }
}

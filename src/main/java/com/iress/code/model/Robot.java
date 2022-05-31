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
    // maxX, maxY
    public static final int minX = 0;
    public static final int minY = 0;
    public static final int maxX = 5;
    public static final int maxY = 5;

    // TODO: we might need to check the initial robot boundary before move or rotate
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
                if (checkPositionHazard(x ,y)) {
                    x++;
                    warn(x, y);
                }
                break;
        }
    }

    private void warn (int x, int y) {
        log.warn("Hazard: return to " + x + ", " + y);
//        throw new RuntimeException("Hazard: return to " + x + ", " + y);
    }

    private boolean checkPositionHazard(int x, int y) {
        return x < minX || (x > maxX || y < minY || y > maxY);
    }

    public void leftRotate() {
        if (!checkPositionHazard(x ,y)){
            direction = direction.turn(Turn.LEFT);
        }
    }

    public void rightRotate() {
        if (!checkPositionHazard(x ,y)){
            direction = direction.turn(Turn.RIGHT);
        }
    }

    public String checkStatus() {
        return x + ","+ y + "," + direction;
    }

}

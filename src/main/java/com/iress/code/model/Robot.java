package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Robot {
    private final int[] position;
    private Direction direction;

    // TODO: add error handler: check initial position and direction
    // TODO: try better lambda writing ways
    public void move() {
        switch (direction) {
            case NORTH:
                position[1]++;
                if (checkPositionHazard(position)) {
                    position[1]--;
                }
                break;
            case SOUTH:
                position[1]--;
                if (checkPositionHazard(position)) {
                    position[1]++;
                }
                break;
            case EAST:
                position[0]++;
                if (checkPositionHazard(position)) {
                    position[0]--;
                }
                break;
            case WEST:
                position[0]--;
                if (checkPositionHazard(position)) {
                    position[0]++;
                }
                break;
        }
    }

    private boolean checkPositionHazard(int[] position) {
        // TODO: add hazard error message
        return position[0] < 0 || (position[0] > 5 || position[1] < 0 || position[1] > 5);
    }

    public void leftRotate() {
        direction = Direction.values()[direction.ordinal() + 1];
    }

    public void rightRotate() {
        direction = Direction.values()[direction.ordinal() - 1];
    }
}

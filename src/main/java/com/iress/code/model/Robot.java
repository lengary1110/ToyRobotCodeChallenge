package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@Slf4j
public class Robot {
    private final int[] position;
    private Direction direction;
    // TODO: try better writing ways
    public void move() {
        switch (direction) {
            case NORTH:
                position[1]++;
                if (checkPositionHazard(position)) {
                    position[1]--;
                    log.warn("Hazard: return to " + Arrays.toString(position));
                }
                break;
            case SOUTH:
                position[1]--;
                if (checkPositionHazard(position)) {
                    position[1]++;
                    log.warn("Hazard: return to " + Arrays.toString(position));
                }
                break;
            case EAST:
                position[0]++;
                if (checkPositionHazard(position)) {
                    position[0]--;
                    log.warn("Hazard: return to " + Arrays.toString(position));
                }
                break;
            case WEST:
                position[0]--;
                if (checkPositionHazard(position)) {
                    position[0]++;
                    log.warn("Hazard: return to " + Arrays.toString(position));
                }
                break;
        }
    }

    private boolean checkPositionHazard(int[] position) {
        return position[0] < 0 || (position[0] > 5 || position[1] < 0 || position[1] > 5);
    }

    public void leftRotate() {
        direction = Direction.values()[direction.ordinal() + 1];
    }

    public void rightRotate() {
        direction = Direction.values()[direction.ordinal() - 1];
    }
}

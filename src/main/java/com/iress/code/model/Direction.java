package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.iress.code.utils.ToyRobotConstants.*;

@Getter
@AllArgsConstructor
public enum Direction {
    NORTH(NORTH_NAME) {
        Direction left() {
            return WEST;
        }

        Direction right() {
            return EAST;
        }
    },
    EAST(EAST_NAME) {
        Direction left() {
            return NORTH;
        }

        Direction right() {
            return SOUTH;
        }
    },
    SOUTH(SOUTH_NAME) {
        Direction left() {
            return EAST;
        }

        Direction right() {
            return WEST;
        }
    },
    WEST(WEST_NAME) {
        Direction left() {
            return SOUTH;
        }

        Direction right() {
            return NORTH;
        }
    };

    private final String directionName;

    abstract Direction left();

    abstract Direction right();

    public Direction turn(Turn where) {
        return where == Turn.LEFT ? this.left() : this.right();
    }
}

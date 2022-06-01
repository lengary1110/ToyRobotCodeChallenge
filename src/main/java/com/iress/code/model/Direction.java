package com.iress.code.model;

import lombok.Getter;

@Getter
public enum Direction {
    NORTH {
        Direction left() {
            return WEST;
        }

        Direction right() {
            return EAST;
        }
    },
    EAST {
        Direction left() {
            return NORTH;
        }

        Direction right() {
            return SOUTH;
        }
    },
    SOUTH {
        Direction left() {
            return EAST;
        }

        Direction right() {
            return WEST;
        }
    },
    WEST {
        Direction left() {
            return SOUTH;
        }

        Direction right() {
            return NORTH;
        }
    };

    abstract Direction left();

    abstract Direction right();

    public Direction turn(Turn where) {
        return where == Turn.LEFT ? this.left() : this.right();
    }
}

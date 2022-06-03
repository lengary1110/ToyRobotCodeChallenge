package com.iress.code.model;

import com.iress.code.output.OutputHandler;

public enum Operator {
    MOVE {
        public void operate(Robot robot) {
            robot.move();
        }
    },
    LEFT {
        public void operate(Robot robot) {
            robot.leftRotate();
        }
    },
    RIGHT {
        public void operate(Robot robot) {
            robot.rightRotate();
        }
    },
    REPORT {
        private final OutputHandler outputHandler = new OutputHandler();

        public void operate(Robot robot) {
            outputHandler.handle(robot);
        }
    };

    abstract public void operate(Robot robot);
}

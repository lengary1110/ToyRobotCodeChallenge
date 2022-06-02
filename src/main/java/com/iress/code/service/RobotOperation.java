package com.iress.code.service;

import com.iress.code.model.Direction;
import com.iress.code.model.Position;
import com.iress.code.model.Robot;
import com.iress.code.output.OutputHandler;

import static com.iress.code.utils.ToyRobotConstants.*;

public class RobotOperation {

    public Robot initialRobot(int x, int y, Direction direction) {
        return new Robot(new Position(x, y, direction));
    }

    public void operateRobot(Robot robot, String operateCmd) {
        switch (operateCmd) {
            case MOVE_OPERATION:
                robot.move();
                break;
            case LEFT_OPERATION:
                robot.leftRotate();
                break;
            case RIGHT_OPERATION:
                robot.rightRotate();
                break;
        }
    }

    public void outputRobot(Robot robot) {
        new OutputHandler().handle(robot);
    }
}

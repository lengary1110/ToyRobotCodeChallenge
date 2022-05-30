package com.iress.code.algorithm;

import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCmd;
import com.iress.code.model.Robot;
import com.iress.code.output.OutputHandler;

public class RobotOperation {
    public Robot initialRobot(int x, int y, Direction direction) {
        return new Robot(x, y, direction);
    }

    public void operateRobot(Robot robot, OperationalCmd operateCommand) {
        if (operateCommand.equals(OperationalCmd.MOVE)) {
            robot.move();
        } else if (operateCommand.equals(OperationalCmd.LEFT)) {
            robot.leftRotate();
        } else if (operateCommand.equals(OperationalCmd.RIGHT)) {
            robot.rightRotate();
        }
    }

    public void outputRobot(Robot robot) {
        new OutputHandler().handle(robot);
    }
}

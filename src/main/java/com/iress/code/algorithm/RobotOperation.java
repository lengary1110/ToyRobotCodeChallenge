package com.iress.code.algorithm;

import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCmd;
import com.iress.code.model.Robot;
import com.iress.code.output.OutputHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RobotOperation {
    public Robot initialRobot(int[] position, Direction direction) {
        return new Robot(position, direction);
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

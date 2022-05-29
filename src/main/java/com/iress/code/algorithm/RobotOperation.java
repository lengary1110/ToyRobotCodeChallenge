package com.iress.code.algorithm;

import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCommand;
import com.iress.code.model.Robot;
import com.iress.code.output.OutputHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// TODO: add log
public class RobotOperation {
    public Robot initialRobot(int[] position, Direction direction) {
        return new Robot(position, direction);
    }

    public void operateRobot(Robot robot, OperationalCommand operateCommand) {
        if (operateCommand.equals(OperationalCommand.MOVE)) {
            robot.move();
        } else if (operateCommand.equals(OperationalCommand.LEFT)) {
            robot.leftRotate();
        } else if (operateCommand.equals(OperationalCommand.RIGHT)) {
            robot.rightRotate();
        }
    }

    public void outputRobot(Robot robot) {
        new OutputHandler().handle(robot);
    }
}

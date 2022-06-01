package com.iress.code.service;

import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCmd;
import com.iress.code.model.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotOperationTest {

    @Test
    public void leftCmd_returnValidDirection() {
        Robot robot = new Robot(0, 0, Direction.NORTH);
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, OperationalCmd.LEFT);
        Assertions.assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    public void rightCmd_returnValidDirection() {
        Robot robot = new Robot(0, 0, Direction.NORTH);
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, OperationalCmd.RIGHT);
        Assertions.assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void moveCmd_returnValidPosition() {
        Robot robot = new Robot(0 ,0, Direction.NORTH);
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, OperationalCmd.MOVE);
        Assertions.assertEquals(1, robot.getY());
    }
}

package com.iress.code.algorithm;

import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCmd;
import com.iress.code.model.Robot;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotOperationTest {
    Robot robot;

    @Test
    public void leftCmd_returnValidDirection() {
        robot = new Robot(0, 0, Direction.NORTH);
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, OperationalCmd.LEFT);
        Assertions.assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    public void rightCmd_returnValidDirection() {
        robot = new Robot(0, 0, Direction.NORTH);
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, OperationalCmd.RIGHT);
        Assertions.assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void moveCmd_returnValidPosition() {
        robot = new Robot(0 ,0, Direction.NORTH);
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, OperationalCmd.MOVE);
        Assertions.assertEquals(1, robot.getY());
    }
}

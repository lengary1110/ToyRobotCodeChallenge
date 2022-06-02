package com.iress.code.service;

import com.iress.code.model.Direction;
import com.iress.code.model.Position;
import com.iress.code.model.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.iress.code.utils.ToyRobotConstants.*;


public class RobotOperationTest {

    @Test
    public void leftCmd_returnValidDirection() {
        Robot robot = new Robot(new Position(0, 0, Direction.NORTH));
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, LEFT_OPERATION);
        Assertions.assertEquals(Direction.WEST, robot.getPosition().getDirection());
    }

    @Test
    public void rightCmd_returnValidDirection() {
        Robot robot = new Robot(new Position(0, 0, Direction.NORTH));
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, RIGHT_OPERATION);
        Assertions.assertEquals(Direction.EAST, robot.getPosition().getDirection());
    }

    @Test
    public void moveCmd_returnValidPosition() {
        Robot robot = new Robot(new Position(0, 0, Direction.NORTH));
        RobotOperation robotOperation = new RobotOperation();
        robotOperation.operateRobot(robot, MOVE_OPERATION);
        Assertions.assertEquals(1, robot.getPosition().getY());
    }
}

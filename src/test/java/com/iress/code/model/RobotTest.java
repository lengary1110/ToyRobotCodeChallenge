package com.iress.code.model;

import com.iress.code.exception.ToyRobotException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {
    private Robot robot;

    @Test
    public void robotInNorth_move_returnValidPosition() {
        robot = new Robot(3, 3, Direction.NORTH);
        robot.move();
        Assertions.assertEquals(4, robot.getY());
    }

    @Test
    public void robotInSouth_move_returnValidPosition() {
        robot = new Robot(3, 3, Direction.SOUTH);
        robot.move();
        Assertions.assertEquals(2, robot.getY());
    }

    @Test
    public void setRobotInEast_move_returnValidPosition() {
        robot = new Robot(3, 3, Direction.EAST);
        robot.move();
        Assertions.assertEquals(4, robot.getX());
    }

    @Test
    public void setRobotInWest_move_returnValidPosition() {
        robot = new Robot(3, 3, Direction.WEST);
        robot.move();
        Assertions.assertEquals(2, robot.getX());
    }

    @Test
    public void robotInNorth_In_Hazard_Move_returnException() {
        Assertions.assertThrows(ToyRobotException.class,
                () -> new Robot(6, 6, Direction.NORTH));
    }
}

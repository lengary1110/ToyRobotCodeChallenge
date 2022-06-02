package com.iress.code.model;

import com.iress.code.exception.ToyRobotException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {
    private Robot robot;

    @Test
    public void robotInNorth_move_returnValidPosition() {
        robot = new Robot(new Position(3, 3, Direction.NORTH));
        robot.move();
        Assertions.assertEquals(4, robot.getPosition().getY());
    }

    @Test
    public void robotInSouth_move_returnValidPosition() {

        robot = new Robot(new Position(3, 3, Direction.SOUTH));
        robot.move();
        Assertions.assertEquals(2, robot.getPosition().getY());
    }

    @Test
    public void setRobotInEast_move_returnValidPosition() {
        robot = new Robot(new Position(3, 3, Direction.EAST));
        robot.move();
        Assertions.assertEquals(4, robot.getPosition().getX());
    }

    @Test
    public void setRobotInWest_move_returnValidPosition() {
        robot = new Robot(new Position(3, 3, Direction.WEST));
        robot.move();
        Assertions.assertEquals(2, robot.getPosition().getX());
    }

    @Test
    public void robotInNorth_In_Hazard_Move_returnException() {
        Assertions.assertThrows(ToyRobotException.class,
                () -> new Robot(new Position(6, 6, Direction.NORTH)));
    }
}

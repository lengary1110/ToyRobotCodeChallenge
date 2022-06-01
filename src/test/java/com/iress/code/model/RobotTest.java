package com.iress.code.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

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

//    @Test
//    public void robotInNorth_In_Hazard_Move_returnOldPosition() {
//        robot = new Robot(6, 6, Direction.NORTH);
//        robot.move();
//        Assertions.assertEquals(6, robot.getY());
//    }
//
//    @Test
//    public void robotInSouth_In_Hazard_returnOldPosition() {
//        robot = new Robot(6, 6, Direction.SOUTH);
//        robot.move();
//        Assertions.assertEquals(6, robot.getY());
//    }
//
//    @Test
//    public void robotInWest_In_Hazard_returnOldPosition() {
//        robot = new Robot(6, 6, Direction.WEST);
//        robot.move();
//        Assertions.assertEquals(6, robot.getX());
//    }
//
//    @Test
//    public void robotInEast_In_Hazard_returnOldPosition() {
//        robot = new Robot(6, 6, Direction.EAST);
//        robot.move();
//        Assertions.assertEquals(6, robot.getX());
//    }
//
//    @Test
//    public void robot_In_Hazard_returnOldDirection() {
//        robot = new Robot(6, 6, Direction.EAST);
//        robot.move();
//        Assertions.assertEquals(Direction.EAST, robot.getDirection());
//    }
}

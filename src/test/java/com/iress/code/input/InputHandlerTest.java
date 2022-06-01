package com.iress.code.input;

import com.iress.code.model.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class InputHandlerTest {
    @Test
    public void play_with_test_input_a() throws IOException {
        InputData inputData = new FileInputData(new File("./src/test/resources/test_input_a.txt"));
        InputHandler inputHandler = new InputHandler();
        Robot robot = inputHandler.playToyRobot(inputData);
        Assertions.assertEquals("0,2,WEST", robot.checkStatus());
    }
    @Test
    public void play_with_test_input_b() throws IOException {
        InputData inputData = new FileInputData(new File("./src/test/resources/test_input_b.txt"));
        InputHandler inputHandler = new InputHandler();
        Robot robot = inputHandler.playToyRobot(inputData);
        Assertions.assertEquals("0,0,WEST", robot.checkStatus());
    }

    @Test
    public void play_with_test_input_c() throws IOException {
        InputData inputData = new FileInputData(new File("./src/test/resources/test_input_c.txt"));
        InputHandler inputHandler = new InputHandler();
        Robot robot = inputHandler.playToyRobot(inputData);
        Assertions.assertEquals("4,2,EAST", robot.checkStatus());
    }

    @Test
    public void play_with_test_input_d() throws IOException {
        InputData inputData = new FileInputData(new File("./src/test/resources/test_input_d.txt"));
        InputHandler inputHandler = new InputHandler();
        Robot robot = inputHandler.playToyRobot(inputData);
        Assertions.assertEquals("8,4,EAST", robot.checkStatus());
    }

    @Test
    public void play_with_test_input_e() throws IOException {
        InputData inputData = new FileInputData(new File("./src/test/resources/test_input_e.txt"));
        InputHandler inputHandler = new InputHandler();
        Robot robot = inputHandler.playToyRobot(inputData);
        Assertions.assertEquals("5,4,NORTH", robot.checkStatus());
    }

    @Test
    public void play_with_test_input_f() throws IOException {
        InputData inputData = new FileInputData(new File("./src/test/resources/test_input_f.txt"));
        InputHandler inputHandler = new InputHandler();
        Robot robot = inputHandler.playToyRobot(inputData);
        Assertions.assertEquals("3,2,EAST", robot.checkStatus());
    }
}

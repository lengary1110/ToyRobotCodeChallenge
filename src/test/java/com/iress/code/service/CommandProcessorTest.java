package com.iress.code.service;

import com.iress.code.exception.ToyRobotException;
import com.iress.code.model.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CommandProcessorTest {
    @Test
    public void play_with_test_input_a() throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobotGame("./src/test/resources/test_input_a.txt");
        Assertions.assertEquals("4,4,SOUTH", robot.toString());
    }

    @Test
    public void play_with_test_input_b() throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobotGame("./src/test/resources/test_input_b.txt");
        Assertions.assertEquals("0,0,WEST", robot.toString());
    }

    @Test
    public void play_with_test_input_c() throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobotGame("./src/test/resources/test_input_c.txt");
        Assertions.assertEquals("4,2,EAST", robot.toString());
    }

    @Test
    public void play_with_test_input_d() {
        CommandProcessor commandProcessor = new CommandProcessor();
        Assertions.assertThrows(ToyRobotException.class,
                () -> commandProcessor.playToyRobotGame("./src/test/resources/test_input_d.txt"));
    }

    @Test
    public void play_with_test_input_e() throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobotGame("./src/test/resources/test_input_e.txt");
        Assertions.assertEquals("5,4,NORTH", robot.toString());
    }

    @Test
    public void play_with_test_input_f() throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobotGame("./src/test/resources/test_input_f.txt");
        Assertions.assertEquals("3,2,EAST", robot.toString());
    }
}

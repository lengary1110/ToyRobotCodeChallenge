package com.iress.code.input;

import com.iress.code.exception.ToyRobotException;
import com.iress.code.model.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CommandProcessorTest {
    @Test
    public void play_with_test_input_a() throws IOException {
        File file = new File("./src/test/resources/test_input_a.txt");
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobot(file);
        Assertions.assertEquals("4,4,SOUTH", robot.checkStatus());
    }
    @Test
    public void play_with_test_input_b() throws IOException {
        File file = new File("./src/test/resources/test_input_b.txt");
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobot(file);
        Assertions.assertEquals("0,0,WEST", robot.checkStatus());
    }

    @Test
    public void play_with_test_input_c() throws IOException {
        File file = new File("./src/test/resources/test_input_c.txt");
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobot(file);
        Assertions.assertEquals("4,2,EAST", robot.checkStatus());
    }

    @Test
    public void play_with_test_input_d() {
        File file = new File("./src/test/resources/test_input_d.txt");
        CommandProcessor commandProcessor = new CommandProcessor();
        Assertions.assertThrows(ToyRobotException.class,
                () -> commandProcessor.playToyRobot(file));
    }

    @Test
    public void play_with_test_input_e() throws IOException {
        File file = new File("./src/test/resources/test_input_e.txt");
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobot(file);
        Assertions.assertEquals("5,4,NORTH", robot.checkStatus());
    }

    @Test
    public void play_with_test_input_f() throws IOException {
        File file = new File("./src/test/resources/test_input_f.txt");
        CommandProcessor commandProcessor = new CommandProcessor();
        Robot robot = commandProcessor.playToyRobot(file);
        Assertions.assertEquals("3,2,EAST", robot.checkStatus());
    }
}

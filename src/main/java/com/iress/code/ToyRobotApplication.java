package com.iress.code;

import com.iress.code.input.CommandProcessor;

import java.io.File;
import java.io.IOException;

import static com.iress.code.utils.ToyRobotConstants.INPUT_FILE_NAME;

public class ToyRobotApplication {

    public static void main(String[] args) throws IOException {
        File file = new File("./src/main/resources/" + INPUT_FILE_NAME);
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.playToyRobot(file);
    }
}

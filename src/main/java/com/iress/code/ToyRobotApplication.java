package com.iress.code;

import com.iress.code.service.CommandProcessor;

import java.io.IOException;

import static com.iress.code.utils.ToyRobotConstants.INPUT_FILE_NAME;

public class ToyRobotApplication {

    public static void main(String[] args) throws IOException {
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.playToyRobotGame(INPUT_FILE_NAME);
    }
}

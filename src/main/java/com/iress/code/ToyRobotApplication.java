package com.iress.code;

import com.iress.code.input.FileInputData;
import com.iress.code.input.InputData;
import com.iress.code.input.InputHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

import static com.iress.code.utils.ToyRobotConstants.INPUT_FILE_NAME;

@SpringBootApplication
public class ToyRobotApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ToyRobotApplication.class, args);
        InputData inputData = new FileInputData
                    (new File("./src/main/resources/" + INPUT_FILE_NAME));
        InputHandler inputHandler = new InputHandler();
        inputHandler.playToyRobot(inputData);
    }
}

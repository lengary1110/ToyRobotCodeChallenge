package com.iress.code.output;

import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

import static com.iress.code.utils.ToyRobotConstants.OUTPUT_DESCRIPTION;

@Slf4j
public class OutputHandler {
    public void handle(Robot robot) {
        String outputStr =
                OUTPUT_DESCRIPTION +
                robot.getPosition().checkStatus();
        log.info(outputStr);
        System.out.println(outputStr);
    }
}

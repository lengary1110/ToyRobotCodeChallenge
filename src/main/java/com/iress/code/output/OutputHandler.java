package com.iress.code.output;

import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

import static com.iress.code.utils.ToyRobotConstants.OUTPUT_DESCRIPTION;

@Slf4j
public class OutputHandler {
    public void handle(Robot robot) {
        StringBuilder outputStr = new StringBuilder();
        outputStr.append(OUTPUT_DESCRIPTION)
                .append(robot.getPosition().checkStatus());
        System.out.println(outputStr);
    }
}

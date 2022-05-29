package com.iress.code.output;

import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OutputHandler {
    StringBuilder outputStr = new StringBuilder();
    public void handle(Robot robot) {
        outputStr.append("Output: ")
                .append(robot.getPosition()[0])
                .append(",")
                .append(robot.getPosition()[1])
                .append(",")
                .append(robot.getDirection().getDirectionName());
        System.out.println(outputStr);
    }
}

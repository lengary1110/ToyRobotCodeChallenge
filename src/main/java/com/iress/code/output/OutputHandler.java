package com.iress.code.output;

import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

import static com.iress.code.utils.ToyRobotConstants.COMMA_REGX;
import static com.iress.code.utils.ToyRobotConstants.OUTPUT_DESCRIPTION;

@Slf4j
public class OutputHandler {
    public void handle(Robot robot) {
        StringBuilder outputStr = new StringBuilder();
        outputStr.append(OUTPUT_DESCRIPTION)
                .append(robot.getPosition()[0])
                .append(COMMA_REGX)
                .append(robot.getPosition()[1])
                .append(COMMA_REGX)
                .append(robot.getDirection().getDirectionName());
        System.out.println(outputStr);
        log.info(outputStr.toString());
    }
}

package com.iress.code.output;

import com.iress.code.dtos.OutputDto;
import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j

public class OutputHandler {
    public void handle(Robot robot) {
        OutputDto.builder()
                .description("Output: ")
                .direction(robot.getDirection())
                .position(robot.getPosition())
                .build();
        System.out.println(Arrays.toString(robot.getPosition()));
        System.out.println(robot.getDirection().getDirectionName());
    }
}

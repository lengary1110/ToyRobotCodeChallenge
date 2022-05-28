package com.iress.code.algorithm;

import com.iress.code.dtos.InputDto;
import com.iress.code.model.OperationalCommand;
import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
// TODO: add log
public class RobotOperation {
    public Robot run(InputDto inputDto) {
        Robot robot = new Robot(inputDto.getPosition(), inputDto.getDirection());
        operateRobot(robot, inputDto.getOperateCommands());
        return robot;
    }

    private void operateRobot(Robot robot, ArrayList<OperationalCommand> operateCommands) {
        operateCommands.forEach(operateCommand -> {
            if (operateCommand.equals(OperationalCommand.MOVE)) {
                robot.move();
            } else if (operateCommand.equals(OperationalCommand.LEFT)) {
                robot.leftRotate();
            } else if (operateCommand.equals(OperationalCommand.RIGHT)) {
                robot.rightRotate();
            }
        });
    }
}

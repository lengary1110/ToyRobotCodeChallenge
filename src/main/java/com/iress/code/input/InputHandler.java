package com.iress.code.input;

import com.iress.code.algorithm.RobotOperation;
import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCmd;
import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

import static com.iress.code.utils.ToyRobotConstants.*;

@Slf4j
public class InputHandler {
    private Robot robot;

    public Robot playToyRobot(InputData inputData) {
        RobotOperation robotOperation = new RobotOperation();
        while (inputData.hasNextLine()) {
            String s = inputData.nextLine();
            if (checkIfRobotFinallyInitialized(s)) playWithRobot(s, robotOperation);
            else initialRobot(s, robotOperation);
        }
        return robot;
    }

    private boolean checkIfRobotFinallyInitialized(String s) {
        return robot != null && !isValidLine(s, PLACE_REGEX_COMMAND);
    }

    private void playWithRobot(String s, RobotOperation robotOperation) {
        if (isValidLine(s, REPORT_REGEX_COMMAND)) robotOperation.outputRobot(robot);
        else if (isValidLine(s, OPERATIONAL_REGEX_COMMAND))
            robotOperation.operateRobot(robot, OperationalCmd.valueOf(s));
        else errorHandler(AFTER_PLACE_SKIP_MSG, s);
    }

    private void initialRobot(String s, RobotOperation robotOperation) {
        if (isValidLine(s, PLACE_REGEX_COMMAND)) {
            String[] placeInfo = s.split(SPACE_REGX)[1].split(COMMA_REGX);
            int x = Integer.parseInt(placeInfo[0]);
            int y = Integer.parseInt(placeInfo[1]);
            Direction direction = Direction.valueOf(placeInfo[2]);
            robot = robotOperation.initialRobot(x, y, direction);
        } else {
            errorHandler(NO_PLACE_SKIP_MSG, s);
        }
    }

    private boolean isValidLine(String line, String REGEX_COMMAND) {
        return Pattern.compile(REGEX_COMMAND).matcher(line).find();
    }

    private void errorHandler(String errorMessage, String s) {
        log.error(errorMessage, s);
    }
}

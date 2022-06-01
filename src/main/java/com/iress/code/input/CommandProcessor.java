package com.iress.code.input;

import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCmd;
import com.iress.code.model.Robot;
import com.iress.code.service.RobotOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

import static com.iress.code.utils.ToyRobotConstants.*;

@Slf4j
public class CommandProcessor {
    private Robot robot;

    public Robot playToyRobot(File file) throws IOException {
        RobotOperation robotOperation = new RobotOperation();
        FileUtils.readLines(file, Charset.defaultCharset()).forEach(
                cmd -> {
                    if (checkIfRobotFinallyInitialized(cmd)) {
                        playWithRobot(cmd, robotOperation);
                    } else {
                        initialRobot(cmd, robotOperation);
                    }
                }
        );
        return robot;
    }

    private boolean checkIfRobotFinallyInitialized(String cmd) {
        return robot != null && !isValidLine(cmd, PLACE_REGEX_COMMAND);
    }

    private void playWithRobot(String cmd, RobotOperation robotOperation) {
        if (isValidLine(cmd, REPORT_REGEX_COMMAND)) {
            robotOperation.outputRobot(robot);
        } else if (isValidLine(cmd, OPERATIONAL_REGEX_COMMAND)) {
            robotOperation.operateRobot(robot, OperationalCmd.valueOf(cmd));
        } else {
            errorHandler(AFTER_PLACE_SKIP_MSG, cmd);
        }
    }

    private void initialRobot(String cmd, RobotOperation robotOperation) {
        if (isValidLine(cmd, PLACE_REGEX_COMMAND)) {
            String[] placeInfo = cmd.split(SPACE_REGX)[1].split(COMMA_REGX);
            int x = Integer.parseInt(placeInfo[0]);
            int y = Integer.parseInt(placeInfo[1]);
            Direction direction = Direction.valueOf(placeInfo[2]);
            robot = robotOperation.initialRobot(x, y, direction);
        } else {
            errorHandler(NO_PLACE_SKIP_MSG, cmd);
        }
    }

    private boolean isValidLine(String cmd, String REGEX_COMMAND) {
        return Pattern.compile(REGEX_COMMAND).matcher(cmd).find();
    }

    private void errorHandler(String errorMessage, String s) {
        log.error(errorMessage, s);
    }
}

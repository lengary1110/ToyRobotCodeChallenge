package com.iress.code.service;

import com.iress.code.model.Direction;
import com.iress.code.model.Operator;
import com.iress.code.model.Position;
import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Pattern;

import static com.iress.code.utils.ToyRobotConstants.*;

@Slf4j
public class CommandProcessor {

    public Robot playToyRobotGame(String fileName) throws IOException {
        File file = new File(fileName);
        List<String> commands = FileUtils.readLines(file, Charset.defaultCharset());
        return processCommands(commands);
    }

    private Robot processCommands(List<String> commands) {
        Robot robot = null;
        for (String cmd : commands) {
            if (checkIfRobotFinallyInitialized(robot, cmd)) {
                play(robot, cmd);
            } else {
                robot = initial(cmd);
            }
        }
        return robot;
    }

    private boolean checkIfRobotFinallyInitialized(Robot robot, String cmd) {
        return robot != null && isInvalidCmd(cmd, PLACE_REGEX_COMMAND);
    }

    private void play(Robot robot, String cmd) {
        if (isInvalidCmd(cmd, OPERATION_REGEX_COMMAND)) {
            errorHandler(AFTER_PLACE_SKIP_MSG, cmd);
            return;
        }
        Operator.valueOf(cmd).operate(robot);
    }

    private Robot initial(String cmd) {
        if (isInvalidCmd(cmd, PLACE_REGEX_COMMAND)) {
            errorHandler(NO_PLACE_SKIP_MSG, cmd);
            return null;
        }
        String[] placeInfo = cmd.split(SPACE_REGX)[1].split(COMMA_REGX);
        int x = Integer.parseInt(placeInfo[0]);
        int y = Integer.parseInt(placeInfo[1]);
        return new Robot(new Position(x, y), Direction.valueOf(placeInfo[2]));
    }

    private boolean isInvalidCmd(String cmd, String REGEX_COMMAND) {
        return !Pattern.compile(REGEX_COMMAND).matcher(cmd).find();
    }

    private void errorHandler(String errorMessage, String s) {
        log.error(errorMessage, s);
    }
}

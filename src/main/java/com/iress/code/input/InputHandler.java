package com.iress.code.input;

import com.iress.code.algorithm.RobotOperation;
import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCmd;
import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import static com.iress.code.utils.ToyRobotConstants.*;

@Slf4j
public class InputHandler {
    private static final String PLACE_REGEX_COMMAND = "^PLACE \\d{1,},\\d{1,},(NORTH|SOUTH|EAST|WEST$)";
    private static final String OPERATIONAL_REGEX_COMMAND = "^(MOVE|LEFT|RIGHT)$";
    private static final String REPORT_REGEX_COMMAND = "^REPORT$";
    private static final String NO_PLACE_SKIP_MSG = "Skip commandline: {} because the game not started until a PLACE found";
    private static final String AFTER_PLACE_SKIP_MSG = "Skip commandline: {} it is not an valid operational or report commandline";
    private Robot robot;

    public void handle() throws IOException {
        InputData inputData = new FileInputData
                (new File("./src/main/resources/" + INPUT_FILE_NAME));
        RobotOperation robotOperation = new RobotOperation();
        while (inputData.hasNextLine()) {
            String s = inputData.nextLine();
            if (checkIfRobotIsInitialized()) playWithRobot(s, robotOperation);
            else initialRobot(s, robotOperation);
        }
    }

    private void playWithRobot(String s, RobotOperation robotOperation) {
        if (isValidLine(s, REPORT_REGEX_COMMAND)) robotOperation.outputRobot(robot);
        else if (isValidLine(s, OPERATIONAL_REGEX_COMMAND))
            robotOperation.operateRobot(robot, OperationalCmd.valueOf(s));
        else errorHandler(AFTER_PLACE_SKIP_MSG, s);
    }

    private boolean checkIfRobotIsInitialized() {
        return robot != null;
    }

    private void initialRobot(String s, RobotOperation robotOperation) {
        if (isValidLine(s, PLACE_REGEX_COMMAND)) {
            String[] placeInfo = s.split(SPACE_REGX)[1].split(COMMA_REGX);
            int[] position = new int[placeInfo.length - 1];
            for (int i = 0; i < placeInfo.length - 1; i++) {
                String possibleNumber = placeInfo[i];
                position[i] = Integer.parseInt(possibleNumber);
            }
            Direction direction = Direction.valueOf(placeInfo[2]);
            robot = robotOperation.initialRobot(position, direction);
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

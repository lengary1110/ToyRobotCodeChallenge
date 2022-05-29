package com.iress.code.input;

import com.iress.code.algorithm.RobotOperation;
import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCommand;
import com.iress.code.model.Robot;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.iress.code.utils.ToyRobotConstants.*;

@Slf4j
public class InputHandler {
    Robot robot;

    private boolean isInOperationalCommand(String value) {
        return Arrays.stream(OperationalCommand.values()).anyMatch(e -> e.name().equals(value));
    }

    private boolean isInDirection(String value) {
        return Arrays.stream(Direction.values()).anyMatch(e -> e.name().equals(value));
    }

    public void handle() {
        Path path = Paths.get(INPUT_FILE_NAME);
        RobotOperation robotOperation = new RobotOperation();
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(s -> {
                // TODO: for if-else separate functions
                // TODO： consider - while, break - to exit
                // TODO: edit/organize error messages and log - keep consistent
                if (s.startsWith(PLACE_OPERATION)) {
                    // TODO: add split error: throw INVALID INITIAL PLACE INFORMATION
                    String[] place = s.split(SPACE_REGX)[1].split(COMMA_REGX);
                    int[] position = new int[place.length - 1];
                    for (int i = 0; i < place.length - 1; i++) {
                        String possibleNumber = place[i];
                        // consider regex: whether p
                        boolean isNumber = Pattern.matches("[0-5]+", possibleNumber);
                        if(isNumber) {
                            position[i] = Integer.parseInt(possibleNumber);
                        }
                        else {
                            log.error("INVALID position: " + place[i]);
                            throw new RuntimeException("INVALID position: " + place[i]);
                        }
                    }
                    if (isInDirection(place[2])) {
                        Direction direction = Direction.valueOf(place[2]);
                        robot = robotOperation.initialRobot(position, direction);
                    } else {
                        log.error("INVALID direction command: " + place[2]);
                        throw new RuntimeException("INVALID direction command: " + place[2]);
                    }
                } else {
                    if (checkIfRobotIsInitialized()) {
                        if (s.startsWith(REPORT_OPERATION)) {
                            robotOperation.outputRobot(robot);
                        } else {
                            if (isInOperationalCommand(s)) {
                                robotOperation.operateRobot(robot, OperationalCommand.valueOf(s));
                            } else {
                                log.error("INVALID operational command: " + s);
                                throw new RuntimeException("INVALID operational command: " + s);
                            }
                        }
                    } else {
                        log.error("NO ROBOT");
                        throw new RuntimeException("NO ROBOT");
                    }
                }
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private boolean checkIfRobotIsInitialized() {
        return robot != null;
    }
}

package com.iress.code.input;

import com.iress.code.dtos.InputDto;
import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCommand;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.iress.code.utils.ToyRobotConstants.*;

@Slf4j
// TODO: add log
public class InputHandler {
    int[] position;
    Direction direction;
    List<OperationalCommand> operateCommands = new ArrayList<>();
    public InputDto handle() {
        Path path = Paths.get("input.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(s -> {
                // TODO: add more error handler
                // TODO: add more regex constant
                // TODO: check first s == "PLACE"
                if (s.startsWith(PLACE_OPERATION)) {
                    String[] place = s.split(" ")[1].split(",");
                    position = new int[place.length - 1];
                    //  TODO: add check position
                    for (int i = 0; i < place.length - 1; i++) {
                        position[i] = Integer.parseInt(place[i]);
                    }
                    if (isInDirection(place[2])) {
                        direction = Direction.valueOf(place[2]);
                    } else {
                        System.out.println("INVALID direction command: " + place[2]);
                    }

                } else if (s.startsWith(REPORT_OPERATION)) {
                    // do nothing
                } else {
                    if (isInOperationalCommand(s)) {
                        operateCommands.add(OperationalCommand.valueOf(s));
                    } else {
                        System.out.println("INVALID operational command: " + s);
                    }
                }
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return InputDto.builder()
                .direction(direction)
                .position(position)
                .operateCommands(operateCommands)
                .build();
    }
    public static boolean isInOperationalCommand(String value) {
        return Arrays.stream(OperationalCommand.values()).anyMatch(e -> e.name().equals(value));
    }
    public static boolean isInDirection(String value) {
        return Arrays.stream(Direction.values()).anyMatch(e -> e.name().equals(value));
    }
}

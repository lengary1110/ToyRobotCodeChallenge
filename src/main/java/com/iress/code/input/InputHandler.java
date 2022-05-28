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
import java.util.stream.Stream;

import static com.iress.code.utils.ToyRobotConstants.*;

@Slf4j
// TODO: add log
public class InputHandler {
    int[] position;
    Direction direction;
    ArrayList<OperationalCommand> operateCommands;
    public InputDto handle() {
        Path path = Paths.get("input.txt");
        // TODO: add more error handler
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(s -> {
                // TODO: extract match STAGE-OPERATION method
                if (s.substring(0, s.length() - PLACE_OPERATION.length()).equals(PLACE_OPERATION)) {
                    String[] place = s.split(" ")[1].split(",");
                    position = new int[place.length - 1];
                    for (int i = 0; i < place.length - 1; i++) {
                        position[i] = Integer.parseInt(place[i]);
                    }
                    direction = Direction.valueOf(place[2]);
                } else if (s.substring(0, s.length() - REPORT_OPERATION.length()).equals(REPORT_OPERATION)) {
                    // do nothing
                } else {
                    // TODO: add more error handler
                    operateCommands.add(OperationalCommand.valueOf(s));
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
}

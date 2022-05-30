package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.iress.code.utils.ToyRobotConstants.*;

@Getter
@AllArgsConstructor
public enum OperationalCmd {
    MOVE(MOVE_OPERATION),
    LEFT(LEFT_OPERATION),
    RIGHT(RIGHT_OPERATION);
    private final String operationName;
}

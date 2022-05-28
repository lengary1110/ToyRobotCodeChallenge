package com.iress.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.iress.code.utils.ToyRobotConstants.PLACE_OPERATION;
import static com.iress.code.utils.ToyRobotConstants.REPORT_OPERATION;

@Getter
@AllArgsConstructor
public enum StageCommand {
    PLACE(PLACE_OPERATION),
    REPORT(REPORT_OPERATION);
    private final String operationName;
}

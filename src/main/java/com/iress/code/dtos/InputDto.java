package com.iress.code.dtos;

import com.iress.code.model.Direction;
import com.iress.code.model.OperationalCommand;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InputDto {
    private int[] position;
    private Direction direction;
    private List<OperationalCommand> operateCommands;
}

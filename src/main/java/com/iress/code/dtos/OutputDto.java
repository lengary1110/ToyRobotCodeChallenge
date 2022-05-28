package com.iress.code.dtos;

import com.iress.code.model.Direction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutputDto {
    private int[] position;
    private Direction direction;
    private String description;
}

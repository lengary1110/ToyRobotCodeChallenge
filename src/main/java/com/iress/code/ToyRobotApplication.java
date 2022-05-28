package com.iress.code;

import com.iress.code.algorithm.RobotOperation;
import com.iress.code.dtos.InputDto;
import com.iress.code.input.InputHandler;
import com.iress.code.model.Robot;
import com.iress.code.output.OutputHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToyRobotApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToyRobotApplication.class, args);
        InputDto inputDto = new InputHandler().handle();
        Robot robot = new RobotOperation().run(inputDto);
        new OutputHandler().handle(robot);
    }
}

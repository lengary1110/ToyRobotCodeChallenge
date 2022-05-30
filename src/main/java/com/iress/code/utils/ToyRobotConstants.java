package com.iress.code.utils;

public class ToyRobotConstants {
    //operational command names
    public static final String MOVE_OPERATION = "MOVE";
    public static final String LEFT_OPERATION = "LEFT";
    public static final String RIGHT_OPERATION = "RIGHT";

    //stage command names
    public static final String PLACE_OPERATION = "PLACE";
    public static final String REPORT_OPERATION = "REPORT";

    //direction names
    public static final String NORTH_NAME = "NORTH";
    public static final String EAST_NAME = "EAST";
    public static final String SOUTH_NAME = "SOUTH";
    public static final String WEST_NAME = "WEST";

    //file names
    public static final String INPUT_FILE_NAME = "input.txt";

    //regex names
    public static final String SPACE_REGX = "\\s+";
    public static final String COMMA_REGX = ",";

    //output description
    public static final String OUTPUT_DESCRIPTION = "Output: ";

    //errorMes
    private static final String SKIP_MSG =
            "Skip command %s because the game not started until a PLACE cmd found";
}

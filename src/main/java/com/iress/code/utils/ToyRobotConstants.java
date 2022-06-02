package com.iress.code.utils;

public class ToyRobotConstants {

    //file names
    public static final String INPUT_FILE_NAME = "input.txt";

    //regex names
    public static final String SPACE_REGX = "\\s+";
    public static final String COMMA_REGX = ",";
    public static final String PLACE_REGEX_COMMAND = "^PLACE \\d{1,},\\d{1,},(NORTH|SOUTH|EAST|WEST$)";
    public static final String OPERATIONAL_REGEX_COMMAND = "^(MOVE|LEFT|RIGHT)$";
    public static final String REPORT_REGEX_COMMAND = "^REPORT$";

    //operational command names
    public static final String MOVE_OPERATION = "MOVE";
    public static final String LEFT_OPERATION = "LEFT";
    public static final String RIGHT_OPERATION = "RIGHT";

    //output description
    public static final String OUTPUT_DESCRIPTION = "Output: ";

    //errorMessage
    public static final String NO_PLACE_SKIP_MSG = "Skip commandline: {} because the game not started until a PLACE found";
    public static final String AFTER_PLACE_SKIP_MSG = "Skip commandline: {} it is not an valid operational or report commandline";

    // units size
    public static final int minX = 0;
    public static final int minY = 0;
    public static final int maxX = 5;
    public static final int maxY = 5;
}

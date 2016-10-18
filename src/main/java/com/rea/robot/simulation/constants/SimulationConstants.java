package com.rea.robot.simulation.constants;

/**
 * This class contains constant variables to be used the application
 * @Operations: None
 * @Developer: Ganguly, Suman
 */

public interface SimulationConstants {
	
	/**
	 * Command Line input handling constants
	 */
	public static String COMMAND_LINE_INPUT = "C";
	public static String FILE_INPUT = "F";

	/**
	 * Command text constants
	 */
	public static String PLACE_COMMAND = "PLACE";
	public static String MOVE_COMMAND = "MOVE";
	public static String LEFT_COMMAND = "LEFT";
	public static String RIGHT_COMMAND = "RIGHT";
	public static String REPORT_COMMAND = "REPORT";
	
	/**
	 * Max table coordinates
	 */
	public static int MAX_X_UNITS = 5;
	public static int MAX_Y_UNITS = 5;

	/**
	 * Min table coordinates
	 */
	public static int MIN_X_UNITS = 0;
	public static int MIN_Y_UNITS = 0;

	/**
	 * Error codes and messages
	 */
	public static String ERROR_CODE_NOT_INITIALIZED = "NI00";
	public static String ERROR_MESSAGE_NOT_INITIALIZED = "Robot is not initialized yet";
	
	public static String ERROR_CODE_COMMAND_INVALID = "CI00";
	public static String ERROR_MESSAGE_COMMAND_INVALID = "Invalid command specified";

	public static String ERROR_CODE_ARGUMENTS_INVALID = "AI00";
	public static String ERROR_MESSAGE_ARGUMENTS_INVALID = "Invalid Arguments!!!! It should be - PLACE <xCoordinate>, <yCoordinate>, <direction>";
	
	public static String ERROR_CODE_PLACE_INVALID = "PI00";
	public static String ERROR_MESSAGE_PLACE_INVALID = "Invalid coordinate specified";

	public static String ERROR_CODE_DIRECTION_INVALID = "DI00";
	public static String ERROR_MESSAGE_DIRECTION_INVALID = "Invalid direction specified";
	
	public static String ERROR_CODE_Y_MAX = "YM00";
	public static String ERROR_MESSAGE_Y_MAX = "No more moves are possible in north direction";
	
	public static String ERROR_CODE_X_MAX = "XM00";
	public static String ERROR_MESSAGE_X_MAX = "No more moves are possible in east direction";

	public static String ERROR_CODE_Y_MIN = "YN00";
	public static String ERROR_MESSAGE_Y_MIN = "No more moves are possible in south direction";
	
	public static String ERROR_CODE_X_MIN = "XN00";
	public static String ERROR_MESSAGE_X_MIN = "No more moves are possible in west direction";
		
	public static String ERROR_CODE_UNKNOWN_EXCEPTION = "UE00";
	public static String ERROR_MESSAGE_UNKNOWN_EXCEPTION = "Unknown error occured while processing the request";

	public static String ERROR_CODE_IO_EXCEPTION = "IE00";
	public static String ERROR_MESSAGE_IO_EXCEPTION = "IO Exception occured while processing the request";
}

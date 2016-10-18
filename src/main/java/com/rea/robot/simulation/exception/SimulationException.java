package com.rea.robot.simulation.exception;

/**
 * This class contains attributes and methods for handling exception
 * @Operations: getErrorCode
 * @Developer: Ganguly, Suman
 */
public class SimulationException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorCode;
	
	/**
	 * The following constructor initialises the exception object with error code and message
	 * @Input - errorCode, errorMessage
	 * @Response - None
	 * @Exception - None
	 */
	public SimulationException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
	}
	
	/**
	 * The following operation returns error code
	 * @Input - None
	 * @Response - errorCode
	 * @Exception - None
	 */
	public String getErrorCode() {
		return this.errorCode;
	}
}

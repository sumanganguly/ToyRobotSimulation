package com.rea.robot.simulation.processor;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.rea.robot.simulation.bean.Robot;
import com.rea.robot.simulation.constants.SimulationConstants;
import com.rea.robot.simulation.exception.SimulationException;
import com.rea.robot.simulation.util.Direction;

/**
 * This class contains operations to handle the command
 * @Operations: handleCommand
 * @Developer: Ganguly, Suman
 */
public class SimulationProcessor {
	
	private static final Logger logger = Logger.getLogger(SimulationProcessor.class.getName());
	
	/**
	 * The following operation processes the command
	 * @Input - robot, command
	 * @Response - robot
	 * @Exception - None
	 */
	public static Robot handleCommand(Robot robot, String command) {
		int startXCoordinate = -1;
		int startYCoordinate = -1;
		Direction startDirection = null;

		try {
			
			if(command != null && command.startsWith(SimulationConstants.PLACE_COMMAND)) {
				logger.info("Processing PLACE command");
				/*
				 * Split the command separated by ,
				 * It must have 3 tokens after splitting
				 */		        	
				String[] parameters = command.substring(5, command.length()).split("\\,");
				if(parameters.length < 3) {
					throw new SimulationException(SimulationConstants.ERROR_CODE_ARGUMENTS_INVALID, SimulationConstants.ERROR_MESSAGE_ARGUMENTS_INVALID);
				} else {
					/*
					 * Extract x, y coordinates and direction from the tokens
					 */		        	
					try {
						startXCoordinate = Integer.parseInt(parameters[0].trim());
						startYCoordinate = Integer.parseInt(parameters[1].trim());
					} catch(NumberFormatException ex) {
						logger.log(Level.SEVERE, "Error while identifying the x, y coordinate from PLACE command", ex);
						throw new SimulationException(SimulationConstants.ERROR_CODE_ARGUMENTS_INVALID, SimulationConstants.ERROR_MESSAGE_ARGUMENTS_INVALID);
					}
					startDirection = Direction.fromString(parameters[2].trim());
					robot = new Robot(startXCoordinate, startYCoordinate, startDirection);
				}
			} else if (command != null && command.trim().equalsIgnoreCase(SimulationConstants.MOVE_COMMAND)) {
				/*
				 * Handling of MOVE command
				 */		        	
				logger.info("Processing MOVE command");
				if(robot == null) {
					throw new SimulationException(SimulationConstants.ERROR_CODE_NOT_INITIALIZED, SimulationConstants.ERROR_MESSAGE_NOT_INITIALIZED);
				} else {
					robot.move();
				}
			} else if (command != null && command.trim().equalsIgnoreCase(SimulationConstants.LEFT_COMMAND)) {
				/*
				 * Handling of LEFT command
				 */		        	
				logger.info("Processing LEFT command");
				if(robot == null) {
					throw new SimulationException(SimulationConstants.ERROR_CODE_NOT_INITIALIZED, SimulationConstants.ERROR_MESSAGE_NOT_INITIALIZED);
				} else {
					robot.left();
				}
			} else if (command != null && command.trim().equalsIgnoreCase(SimulationConstants.RIGHT_COMMAND)) {
				/*
				 * Handling of RIGHT command
				 */		        	
				logger.info("Processing RIGHT command");
				if(robot == null) {
					throw new SimulationException(SimulationConstants.ERROR_CODE_NOT_INITIALIZED, SimulationConstants.ERROR_MESSAGE_NOT_INITIALIZED);
				} else {
					robot.right();
				}
			} else if (command != null && command.trim().equalsIgnoreCase(SimulationConstants.REPORT_COMMAND)) {
				/*
				 * Handling of REPORT command
				 */		        	
				logger.info("Processing REPORT command");
				if(robot == null) {
					throw new SimulationException(SimulationConstants.ERROR_CODE_NOT_INITIALIZED, SimulationConstants.ERROR_MESSAGE_NOT_INITIALIZED);
				} else {
					robot.report();
				}
			} else {
				/*
				 * Invalid input command
				 */		        	
				logger.info("Invalid Input command. Going to raise exception");
				throw new SimulationException(SimulationConstants.ERROR_CODE_COMMAND_INVALID, SimulationConstants.ERROR_MESSAGE_COMMAND_INVALID);
			}
		} catch (SimulationException se) {
			logger.warning("Simulation Exception occured while processing commands: " + se.getErrorCode()+":"+se.getMessage());
		}
		return robot;
	}

}

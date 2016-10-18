package com.rea.robot.simulation.main;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.rea.robot.simulation.constants.SimulationConstants;
import com.rea.robot.simulation.exception.SimulationException;
import com.rea.robot.simulation.reader.SimulationStreamReader;

/**
 * This class contains the main method to prepare the input stream based on command line input (C - for Command line, F - File input and file location as 2nd argument)
 * @Operations: main
 * @Developer: Ganguly, Suman
 */

public class RobotSimulation {
	
	private static final Logger logger = Logger.getLogger(RobotSimulation.class.getName());

	/**
	 * The following main method reads the argument passed during program execution and based of parameters it initialises the input stream
	 * @Input - args
	 * @Response - None
	 * @Exception - None
	 */
	public static void main(String[] args) {
		
		SimulationStreamReader reader = null;
		
		/*
		 * At least one argument to be passed to distinguish between command line and file input processing
		 */
		if(args != null && args.length > 0 && (args[0].equals(SimulationConstants.COMMAND_LINE_INPUT) || args[0].equals(SimulationConstants.FILE_INPUT))) {
			if(args[0] != null && args[0].equals(SimulationConstants.COMMAND_LINE_INPUT)) {
				/*
				 * Use System.in as the input stream for command line
				 */
				reader = new SimulationStreamReader(System.in);
			} else if (args[0] != null && args[0].equals(SimulationConstants.FILE_INPUT)) {
				if(args.length < 2) {
					logger.log(Level.SEVERE, "Invalid number of arguments provided. Please supply only C - for command line, F - for file input along with file location as next argument");
				} else {
					/*
					 * There must be two input arguments. F - file input, file location
					 * Passing FileInputStream as input stream
					 */
					try {
						reader = new SimulationStreamReader(new FileInputStream(args[1]));
					} catch(FileNotFoundException fe) {
						logger.log(Level.SEVERE, "File is not found in the system", fe);
					}
				}
			}
			try {
				reader.process();
			} catch(SimulationException se) {
				logger.log(Level.SEVERE, se.getErrorCode()+":"+se.getMessage());
			}
		} else {
			logger.log(Level.SEVERE, "Invalid number of arguments provided. Please supply only C - for command line, F - for file input along with file location as next argument");
		}
	}
}
package com.rea.robot.simulation.reader;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.rea.robot.simulation.bean.Robot;
import com.rea.robot.simulation.constants.SimulationConstants;
import com.rea.robot.simulation.exception.SimulationException;
import com.rea.robot.simulation.processor.SimulationProcessor;

/**
 * This class contains attributes and operations to read from input stream
 * @Operations: process
 * @Developer: Ganguly, Suman
 */
public class SimulationStreamReader {
	
	private static final Logger logger = Logger.getLogger(SimulationStreamReader.class.getName());
	
	private InputStream inputStream;

	public SimulationStreamReader(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	/**
	 * The following operation reads one line command at a time and calls the processor to process the command
	 * @Input - None
	 * @Response - None
	 * @Exception - None
	 */
	public void process() throws SimulationException {
		if(this.inputStream != null) {
			try {
				
				Robot robot = null;
		        BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));
		        String command = null;
		        
		        do {
					/*
					 * For command line execution, ask user to input the next command
					 */		        	
		        	if (!(this.inputStream instanceof FileInputStream || this.inputStream instanceof ByteArrayInputStream)) {
		        		logger.info("Enter next command:");
		        	}
		        	command = reader.readLine();
					/*
					 * Printing the command if its not command line execution
					 */		        	
		        	if (this.inputStream instanceof FileInputStream || this.inputStream instanceof ByteArrayInputStream) {
		        		logger.info("Current command: "+command);
		        	}
		        	
		        	logger.info("Before calling processor to process the command: "+ command);
					/*
					 * Calling processor to handle the command received from input stream
					 */		        	
		        	robot = SimulationProcessor.handleCommand(robot, command);
		        	logger.info("Processor completed handling the command: "+ command);
		        	
		        } while(!(command != null && command.equalsIgnoreCase(SimulationConstants.REPORT_COMMAND)));
				/*
				 * Closing reader object after processing the input stream
				 */		        	
		        reader.close();
			} catch(IOException ioe) {
				logger.log(Level.SEVERE, "IO Exception occurred while reading the command from input stream", ioe);
				throw new SimulationException(SimulationConstants.ERROR_CODE_IO_EXCEPTION, SimulationConstants.ERROR_MESSAGE_IO_EXCEPTION);
			} catch(Exception ex) {
				logger.log(Level.SEVERE, "Unknown Exception occurred while reading the command from input stream", ex);
				throw new SimulationException(SimulationConstants.ERROR_CODE_UNKNOWN_EXCEPTION, SimulationConstants.ERROR_MESSAGE_UNKNOWN_EXCEPTION);
			}
		} else {
			logger.log(Level.SEVERE, "Null input stream provided");
		}
	}
}
package com.rea.robot.simulation.bean;

import java.util.logging.Logger;

import com.rea.robot.simulation.constants.SimulationConstants;
import com.rea.robot.simulation.exception.SimulationException;
import com.rea.robot.simulation.util.Direction;

/**
 * This class contains attributes of the Robot object and operations that works on those attributes
 * @Operations: move, left, right, report
 * @Developer: Ganguly, Suman
 */
public class Robot {
	
	private static final Logger logger = Logger.getLogger(Robot.class.getName());
	
	private int xCoordinate;
	private int yCoordinate;
	private Direction direction;

	/**
	 * The following constructor initialises the Robot object with its x,y coordinates and direction
	 * @Input - xCoordinate, yCoordinate, direction
	 * @Response - None
	 * @Exception - SimulationException
	 */
	public Robot(int xCoordinate, int yCoordinate, Direction direction) throws SimulationException {
		
		if(xCoordinate >= SimulationConstants.MIN_X_UNITS && xCoordinate <= SimulationConstants.MAX_X_UNITS) {
			this.xCoordinate = xCoordinate;
		} else {
			/*
			 * Assignment can not be done as its beyond allowed coordinate limit
			 */
			throw new SimulationException(SimulationConstants.ERROR_CODE_PLACE_INVALID, SimulationConstants.ERROR_MESSAGE_PLACE_INVALID);
		}
		if(yCoordinate >= SimulationConstants.MIN_Y_UNITS && yCoordinate <= SimulationConstants.MAX_Y_UNITS) {
			this.yCoordinate = yCoordinate;
		} else {
			/*
			 * Assignment can not be done as its beyond allowed coordinate limit
			 */
			throw new SimulationException(SimulationConstants.ERROR_CODE_PLACE_INVALID, SimulationConstants.ERROR_MESSAGE_PLACE_INVALID);
		}
		if(direction != null && (direction == Direction.NORTH || direction == Direction.EAST || direction == Direction.WEST || direction == Direction.SOUTH)) {
			this.direction = direction;
		} else {
			/*
			 * Not a valid direction
			 */
			throw new SimulationException(SimulationConstants.ERROR_CODE_DIRECTION_INVALID, SimulationConstants.ERROR_MESSAGE_DIRECTION_INVALID);
		}
	}
	
	/**
	 * The following operation moves the robot as per the current facing direction
	 * @Input - None
	 * @Response - None
	 * @Exception - SimulationException
	 */
	public void move() throws SimulationException {
		/*
		 * If current direction is NORTH, moving one position will increase yCoordinate by 1
		 */
		if(this.direction == Direction.NORTH) {
			if(this.yCoordinate == SimulationConstants.MAX_Y_UNITS) {
				/*
				 * Can not move any further as it reached maximum allowed limit already
				 */
				throw new SimulationException(SimulationConstants.ERROR_CODE_Y_MAX, SimulationConstants.ERROR_MESSAGE_Y_MAX);
			} else {
				this.yCoordinate =  this.yCoordinate + 1;
			}
			/*
			 * If current direction is EAST, moving one position will increase xCoordinate by 1
			 */
		} else if (this.direction == Direction.EAST) {
			if(this.xCoordinate == SimulationConstants.MAX_X_UNITS) {
				/*
				 * Can not move any further as it reached maximum allowed limit already
				 */
				throw new SimulationException(SimulationConstants.ERROR_CODE_X_MAX, SimulationConstants.ERROR_MESSAGE_X_MAX);
			} else {
				this.xCoordinate = this.xCoordinate + 1;
			}
			/*
			 * If current direction in WEST, moving one position will decrease xCoordinate by 1
			 */
		} else if (this.direction == Direction.WEST) {
			if(this.xCoordinate == SimulationConstants.MIN_X_UNITS) {
				/*
				 * Can not move any further as it reached maximum allowed limit already
				 */
				throw new SimulationException(SimulationConstants.ERROR_CODE_X_MIN, SimulationConstants.ERROR_MESSAGE_X_MIN);
			} else {
				this.xCoordinate = this.xCoordinate - 1;
			}
			/*
			 * If current direction in SOUTH, moving one position will decrease yCoordinate by 1
			 */
		} else if (this.direction == Direction.SOUTH) {
			if(this.yCoordinate == SimulationConstants.MIN_Y_UNITS) {
				/*
				 * Can not move any further as it reached maximum allowed limit already
				 */
				throw new SimulationException(SimulationConstants.ERROR_CODE_Y_MIN, SimulationConstants.ERROR_MESSAGE_Y_MIN);
			} else {
				this.yCoordinate = this.yCoordinate - 1;
			}
		}
	}
	
	/**
	 * The following operation moves the robot to the left side by 90%
	 * @Input - None
	 * @Response - None
	 * @Exception - None
	 */
	public void left() {
		if(this.direction == Direction.NORTH) {
			this.direction = Direction.WEST;
		} else if (this.direction == Direction.EAST) {
			this.direction = Direction.NORTH;
		} else if (this.direction == Direction.WEST) {
			this.direction = Direction.SOUTH;
		} else if (this.direction == Direction.SOUTH) {
			this.direction = Direction.EAST;
		}
	}
	
	/**
	 * The following operation moves the robot to the right side by 90%
	 * @Input - None
	 * @Response - None
	 * @Exception - None
	 */
	public void right() {
		if(this.direction == Direction.NORTH) {
			this.direction = Direction.EAST;
		} else if (this.direction == Direction.EAST) {
			this.direction = Direction.SOUTH;
		} else if (this.direction == Direction.WEST) {
			this.direction = Direction.NORTH;
		} else if (this.direction == Direction.SOUTH) {
			this.direction = Direction.WEST;
		}
	}
	
	/**
	 * The following operation prints the current position of the robot
	 * @Input - None
	 * @Response - None
	 * @Exception - None
	 */
	public void report() {
		logger.info("ROBOT'S CURRENT POSITION: "+this.xCoordinate+", "+this.yCoordinate+", "+this.direction.toString());
	}	
}

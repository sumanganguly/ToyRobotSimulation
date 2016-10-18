package com.rea.robot.simulation.util;

/**
 * This enum class contains different possible direction options
 * @Operations: fromString
 * @Developer: Ganguly, Suman
 */
public enum Direction {
	
	NORTH, EAST, WEST, SOUTH;
	
	/**
	 * The following operation generates Direction enum object from input string
	 * @Input - input
	 * @Response - Direction
	 * @Exception - None
	 */
	public static Direction fromString(String input) {
		if (input != null) {
			for (Direction direction : Direction.values()) {
				if (input.equalsIgnoreCase(direction.toString())) {
					return direction;
				}
			}
		}
		return null;
	}
}

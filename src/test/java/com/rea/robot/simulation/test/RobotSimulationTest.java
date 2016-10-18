package com.rea.robot.simulation.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import org.junit.Test;
import com.rea.robot.simulation.exception.SimulationException;
import com.rea.robot.simulation.reader.SimulationStreamReader;

public class RobotSimulationTest {
	
	private static final Logger logger = Logger.getLogger(RobotSimulationTest.class.getName());

	@Test
	public void testValidScenario() throws SimulationException {
		
		String commands = 
				"PLACE 1,2,NORTH\n" +
				"MOVE\n" +
				"LEFT\n" +
				"RIGHT\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}
	
	@Test
	public void testInvalidStartLeftScenario() throws SimulationException {
		
		String commands = 
				"PLACE 8,8,NORTH\n" +
				"MOVE\n" +
				"LEFT\n" +
				"RIGHT\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}	

	@Test
	public void testNullInputStream() throws SimulationException {
		SimulationStreamReader reader = new SimulationStreamReader(null);
		reader.process();
	}

	@Test
	public void testMaximumNorth() throws SimulationException {
		
		String commands = 
				"PLACE 1,2,NORTH\n" +
				"MOVE\n" +
				"MOVE\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}

	@Test
	public void testMaximumEast() throws SimulationException {
		
		String commands = 
				"PLACE 2,1,EAST\n" +
				"MOVE\n" +
				"MOVE\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}

	@Test
	public void testMaximumWest() throws SimulationException {
		
		String commands = 
				"PLACE 1,2,WEST\n" +
				"MOVE\n" +
				"MOVE\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}

	@Test
	public void testMaximumSouth() throws SimulationException {
		
		String commands = 
				"PLACE 1,2,SOUTH\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}

	@Test
	public void testInvalidStart() throws SimulationException {
		
		String commands = 
				"PLACE -1,-1,NORTH\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}

	@Test
	public void testInvalidStartCoordinate() throws SimulationException {
		
		String commands = 
				"PLACE A,-1,NORTH\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}
	
	@Test
	public void testMaxStartCoordinate() throws SimulationException {
		
		String commands = 
				"PLACE 6,6,NORTH\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}
	
	@Test
	public void testInvalidStartDirection() throws SimulationException {
		
		String commands = 
				"PLACE 0,0,DOWN\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}
	
	
	@Test
	public void testInvalidPlaceCommand() throws SimulationException {
		
		String commands = 
				"PLACE 1,NORTH\n" +
				"MOVE\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}

	@Test
	public void testInvalidCommand() throws SimulationException {
		
		String commands = 
				"PLACE 1,NORTH\n" +
				"TESTCOMM\n" +
				"MOVE\n" +
				"REPORT\n";
		InputStream stream = new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8));
		SimulationStreamReader reader = new SimulationStreamReader(stream);
		reader.process();
	}
}
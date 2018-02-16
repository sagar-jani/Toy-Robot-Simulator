package com.sagarj.robot.toyrobotsimulator;

import com.sagarj.robot.toyrobotsimulator.gridobjects.Coordinates;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Direction;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Grid;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class ToyRobotSimulatorTest {

	@Test
	public void canProvideCurrentLocationAsString() {
		//Given
		Grid plateau = new Grid(5,5);
		Coordinates startingPosition = new Coordinates(3,3);

		//When
		ToyRobotSimulator marsRover = new ToyRobotSimulator(plateau, Direction.NORTH, startingPosition);

		//then
		Assert.assertEquals("3 3 NORTH", marsRover.currentLocation());
	}

	@Test
	public void canRotateLeft() {
		//Given
		Grid plateau = new Grid(5,5);
		Coordinates startingPosition = new Coordinates(1,2);
		ToyRobotSimulator marsRover = new ToyRobotSimulator(plateau, Direction.NORTH, startingPosition);

		//When
		marsRover.turnLeft();

		//then
		Assert.assertEquals("1 2 WEST", marsRover.currentLocation());
	}

	@Test
	public void canRotateRight() {
		//Given
		Grid plateau = new Grid(5,5);
		Coordinates startingPosition = new Coordinates(1,2);
		ToyRobotSimulator marsRover = new ToyRobotSimulator(plateau, Direction.NORTH, startingPosition);

		//When
		marsRover.turnRight();

		//then
		Assert.assertEquals("1 2 EAST", marsRover.currentLocation());
	}

	@Test
	public void canMove() {
		//Given
		Grid plateau = new Grid(5,5);
		Coordinates startingPosition = new Coordinates(1,2);
		ToyRobotSimulator marsRover = new ToyRobotSimulator(plateau, Direction.NORTH, startingPosition);

		//When
		marsRover.move();

		//then
		Assert.assertEquals("1 3 NORTH", marsRover.currentLocation());
	}




}

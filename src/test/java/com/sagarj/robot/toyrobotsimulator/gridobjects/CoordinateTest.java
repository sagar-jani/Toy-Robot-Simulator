package com.sagarj.robot.toyrobotsimulator.gridobjects;

import org.junit.Assert;
import org.junit.Test;


public class CoordinateTest {

	@Test
	public void xCoordinatesAreIncrementedForPositiveValue() {
		Coordinates boundaryCoordinates = new Coordinates(2, 3);

		boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(1, 0);

		Assert.assertEquals("3 3", boundaryCoordinates.toString());
	}

	@Test
	public void xCoordinatesAreDecrementedForNegativeValue() {
		Coordinates boundaryCoordinates = new Coordinates(2, 3);

		boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(-1, 0);

		Assert.assertEquals("1 3", boundaryCoordinates.toString());
	}

	@Test
	public void yCoordinatesAreIncrementedForPositiveValue() {
		Coordinates boundaryCoordinates = new Coordinates(2, 3);

		boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(0, 1);

		Assert.assertEquals("2 4", boundaryCoordinates.toString());
	}

	@Test
	public void yCoordinatesAreDecrementedForNegativeValue() {
		Coordinates boundaryCoordinates = new Coordinates(2, 3);

		boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(0, -1);

		Assert.assertEquals("2 2", boundaryCoordinates.toString());
	}

	@Test
	public void pointWithXCoordinateWithinBoundaryAreIdentified() {
		Coordinates boundaryCoordinates = new Coordinates(5, 5);

		Coordinates internalPoint = new Coordinates(4, 5);

		Assert.assertTrue(boundaryCoordinates.hasWithinBounds(internalPoint));
	}

	@Test
	public void pointWithYCoordinateWithinBoundaryAreIdentified() {
		Coordinates boundaryCoordinates = new Coordinates(5, 5);

		Coordinates internalPoint = new Coordinates(5, 4);

		Assert.assertTrue(boundaryCoordinates.hasWithinBounds(internalPoint));
	}

	@Test
	public void pointsWithXCoordinateOutsideBoundaryAreIdentified() {
		Coordinates boundaryCoordinates = new Coordinates(5, 5);

		Coordinates externalPoint = new Coordinates(8, 5);

		Assert.assertTrue(boundaryCoordinates.hasOutsideBounds(externalPoint));
	}

	@Test
	public void pointsWithYCoordinateOutsideBoundaryAreIdentified() {
		Coordinates boundaryCoordinates = new Coordinates(5, 5);

		Coordinates externalPoint = new Coordinates(5, 8);

		Assert.assertTrue(boundaryCoordinates.hasOutsideBounds(externalPoint));
	}

	@Test
	public void immutableCoordinatesAreCreatedForNewStepSize() {
		Coordinates boundaryCoordinates = new Coordinates(5, 5);

		Coordinates newBoundary = boundaryCoordinates.newCoordinatesFor(1, -1);

		Assert.assertEquals("6 4", newBoundary.toString());
		Assert.assertEquals("5 5", boundaryCoordinates.toString());
	}

}

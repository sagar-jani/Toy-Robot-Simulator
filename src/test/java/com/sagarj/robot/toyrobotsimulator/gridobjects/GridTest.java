package com.sagarj.robot.toyrobotsimulator.gridobjects;

import org.junit.Assert;
import org.junit.Test;

public class GridTest {

	@Test
	public void locationWithCoordinateWithinBoundsIsIdentified() {
		Grid grid = new Grid(5, 5);

		Coordinates GridCoordinates = new Coordinates(5, 0);

		Assert.assertTrue(grid.hasWithinBounds(GridCoordinates));
	}

	@Test
	public void locationWithPositiveXCoordinateOutsideBoundsIsIdentified() {
		Grid grid = new Grid(5, 5);

		Coordinates coordinates = new Coordinates(6, 0);

		Assert.assertFalse(grid.hasWithinBounds(coordinates));
	}

	@Test
	public void locationWithNegativeXCoordinateOutsideBoundsIsIdentified() {
		Grid grid = new Grid(5, 5);

		Coordinates coordinates = new Coordinates(-1, 0);

		Assert.assertFalse(grid.hasWithinBounds(coordinates));
	}

	@Test
	public void locationWithPositiveYCoordinateOutsideBoundsIsIdentified() {
		Grid grid = new Grid(5, 5);

		Coordinates coordinates = new Coordinates(0, 6);

		Assert.assertFalse(grid.hasWithinBounds(coordinates));
	}

	@Test
	public void locationWithNegativeYCoordinateOutsideBoundsIsIdentified() {
		Grid grid = new Grid(5, 5);

		Coordinates coordinates = new Coordinates(0, -1);

		Assert.assertFalse(grid.hasWithinBounds(coordinates));
	}

}

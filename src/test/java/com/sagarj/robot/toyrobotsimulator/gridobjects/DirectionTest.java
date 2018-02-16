package com.sagarj.robot.toyrobotsimulator.gridobjects;

import org.junit.Assert;
import org.junit.Test;


public class DirectionTest {
	
    @Test
    public void westIsOnLeftOfNorth() {
        Direction north = Direction.NORTH;

        Direction west = north.left();

        Assert.assertEquals(Direction.WEST, west);
    }

    @Test
    public void eastIsOnRightOfNorth() {
        Direction north = Direction.NORTH;

        Direction east = north.right();

        Assert.assertEquals(Direction.EAST, east);
    }

    @Test
    public void northIsOnRightOfWest() {
        Direction west = Direction.WEST;

        Direction north = west.right();

        Assert.assertEquals(Direction.NORTH, north);
    }

    @Test
    public void southIsOnLeftOfWest() {
        Direction west = Direction.WEST;

        Direction south = west.left();

        Assert.assertEquals(Direction.SOUTH, south);
    }

    @Test
    public void eastIsOnLeftOfSouth() {
        Direction south = Direction.SOUTH;

        Direction east = south.left();

        Assert.assertEquals(Direction.EAST, east);
    }

    @Test
    public void westIsOnRightOfSouth() {
        Direction south = Direction.SOUTH;

        Direction west = south.right();

        Assert.assertEquals(Direction.WEST, west);
    }

    @Test
    public void northIsOnLeftOfEast() {
        Direction east = Direction.EAST;

        Direction north = east.left();

       Assert.assertEquals(Direction.NORTH, north);
    }

    @Test
    public void southIsOnRightOfEast() {
        Direction east = Direction.EAST;

       Direction south = east.right();

       Assert.assertEquals(Direction.SOUTH, south);
    }

    @Test
    public void eastIsOneStepForwardOnXAxis() {
        Direction east = Direction.EAST;

        int stepSize = east.stepSizeForXAxis();

        Assert.assertEquals(1, stepSize);
    }

    @Test
    public void eastIsStationaryOnYAxis() {
        Direction east = Direction.EAST;

        int stepSize = east.stepSizeForYAxis();

        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void westIsOneStepBackOnXAxis() {
        Direction west = Direction.WEST;

        int stepSize = west.stepSizeForXAxis();

        Assert.assertEquals(-1, stepSize);
    }


    @Test
    public void westIsStationaryOnYAxis() {
        Direction west = Direction.WEST;

        int stepSize = west.stepSizeForYAxis();

        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void northIsOneStepForwardOnYAxis() {
        Direction north = Direction.NORTH;

        int stepSize = north.stepSizeForYAxis();

        Assert.assertEquals(1, stepSize);
    }


    @Test
    public void northIsStationaryOnXAxis() {
        Direction north = Direction.NORTH;

        int stepSize = north.stepSizeForXAxis();

        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void southIsOneStepBackOnYAxis() {
        Direction south = Direction.SOUTH;

        int stepSize = south.stepSizeForYAxis();

        Assert.assertEquals(-1, stepSize);
    }

    @Test
    public void southIsStationaryOnXAxis() {
        Direction south = Direction.SOUTH;

        int stepSize = south.stepSizeForXAxis();

        Assert.assertEquals(0, stepSize);
    }
}

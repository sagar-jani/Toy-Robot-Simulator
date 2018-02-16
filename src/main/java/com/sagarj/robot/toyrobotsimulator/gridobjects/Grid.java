package com.sagarj.robot.toyrobotsimulator.gridobjects;

public class Grid {

    private Coordinates topRightCoordinates = new Coordinates(0, 0);
    private Coordinates bottomLeftCoordinates = new Coordinates(0, 0);

    public Grid(final int topRightXCoordinate, final int topRightYCoordinate) {
        this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(topRightXCoordinate, topRightYCoordinate);
    }

    public boolean hasWithinBounds(final Coordinates coordinates) {
        return this.bottomLeftCoordinates.hasOutsideBounds(coordinates) && this.topRightCoordinates.hasWithinBounds(coordinates);
    }

}

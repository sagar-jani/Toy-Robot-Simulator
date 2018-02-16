package com.sagarj.robot.toyrobotsimulator;

import com.sagarj.robot.toyrobotsimulator.gridobjects.Grid;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Coordinates;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Direction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sagarjani on 14/2/18.
 */
@Component
public class ToyRobotSimulator {

    private static final Log logger = LogFactory.getLog(ToyRobotSimulator.class);

    private Coordinates currentCoordinates;
    private Direction currentDirection;
    private Grid grid;


    /**
     * Constructor injection because all the dependencies are mandatory.
     *
     * @param grid
     * @param direction
     * @param coordinates
     */
    @Autowired
    public ToyRobotSimulator(final Grid grid, final Direction direction, final Coordinates coordinates) {
        this.grid = grid;
        this.currentDirection = direction;
        this.currentCoordinates = coordinates;
    }

    public String currentLocation() {
        return currentCoordinates.toString() + " " + currentDirection.toString();
    }

    public void turnRight() {
        this.currentDirection = this.currentDirection.right();
        logger.info("Turning Right to: " + currentCoordinates + " " + this.currentDirection);
    }

    public void turnLeft() {
        this.currentDirection = this.currentDirection.left();
        logger.info("Turning Left to :" + this.currentCoordinates + " " + this.currentDirection);
    }

    public void move() {

        Coordinates positionAfterMove = currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());

        //ignores the command if robot is being driven off grid
        if (grid.hasWithinBounds(positionAfterMove)) {
            currentCoordinates = currentCoordinates.newCoordinatesFor(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());
        } else {
            logger.info("The new Coordinates: " + positionAfterMove + " are out-of-bound, so not moving forward.");

        }

        logger.info("Moving Forward to :" + currentCoordinates);
    }

    public boolean isPlaceCommandExecuted() {
        if (this.currentCoordinates == null) {
            System.err
                    .print("A valid PLACE command must be issued as first command");
            return false;
        }
        return true;
    }

    public void place(Coordinates startingCoordinates, Direction direction) {
        logger.info("Placing the Toy Robot to :" + startingCoordinates + " " + direction.name());
        if (this.grid.hasWithinBounds(startingCoordinates)) {
            this.currentCoordinates = startingCoordinates;
            this.currentDirection = direction;
        }
    }
}

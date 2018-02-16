package com.sagarj.robot.toyrobotsimulator.jobs;

import com.sagarj.robot.toyrobotsimulator.ToyRobotSimulator;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Coordinates;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Direction;

/**
 * @author SAGARJ
 *         <p>
 *         Using command pattern all the jobs are represented as Objects.
 *         This class is responsible to route the 'Init' jobs.
 */
public class PlaceJob implements Job {

    private Direction direction;
    private Coordinates coordinates;

    public PlaceJob(Direction direction, Coordinates coordinates) {
        this.direction = direction;
        this.coordinates = coordinates;
    }

    @Override
    public void execute(ToyRobotSimulator robot) {
        robot.place(coordinates, direction);
    }

    @Override
    public int getPriority() {
        return JobPriority.PLACE.getPriority();
    }

}

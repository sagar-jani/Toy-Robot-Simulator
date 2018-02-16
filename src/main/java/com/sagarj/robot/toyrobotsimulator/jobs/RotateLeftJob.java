package com.sagarj.robot.toyrobotsimulator.jobs;

import com.sagarj.robot.toyrobotsimulator.ToyRobotSimulator;

public class RotateLeftJob implements Job {

    @Override
    public void execute(final ToyRobotSimulator robot) {
        robot.turnLeft();
    }

    @Override
    public int getPriority() {
        return JobPriority.LEFT.getPriority();
    }

}

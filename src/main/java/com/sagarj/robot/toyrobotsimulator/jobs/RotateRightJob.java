package com.sagarj.robot.toyrobotsimulator.jobs;

import com.sagarj.robot.toyrobotsimulator.ToyRobotSimulator;

public class RotateRightJob implements Job {

    @Override
    public void execute(final ToyRobotSimulator robot) {
        robot.turnRight();
    }

    @Override
    public int getPriority() {
        return JobPriority.RIGHT.getPriority();
    }

}

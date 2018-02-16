package com.sagarj.robot.toyrobotsimulator.jobs;


import com.sagarj.robot.toyrobotsimulator.ToyRobotSimulator;

public class MoveJob implements Job {

    @Override
    public void execute(final ToyRobotSimulator robot) {
        robot.move();
    }

    @Override
    public int getPriority() {
        return JobPriority.MOVE.getPriority();
    }
}

package com.sagarj.robot.toyrobotsimulator.jobs;

import com.sagarj.robot.toyrobotsimulator.ToyRobotSimulator;

/**
 * Created by sagarjani on 14/2/18.
 */
public interface Job {

    final int DEFAULT_PRIORITY = 0;

    void execute(ToyRobotSimulator robot);

    default int getPriority() {
        return DEFAULT_PRIORITY;
    }
}

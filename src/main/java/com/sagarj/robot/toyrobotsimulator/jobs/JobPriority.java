package com.sagarj.robot.toyrobotsimulator.jobs;

/**
 * Created by sagarjani on 16/2/18.
 */
public enum JobPriority {
    PLACE(0),
    MOVE(0),
    LEFT(0),
    RIGHT(0),
    REPORT(1);

    int jobPriority;

    JobPriority(int jobPriority) {
        this.jobPriority = jobPriority;
    }

    public int getPriority() {
        return this.jobPriority;
    }
}

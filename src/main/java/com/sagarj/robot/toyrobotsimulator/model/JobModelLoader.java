package com.sagarj.robot.toyrobotsimulator.model;

import com.sagarj.robot.toyrobotsimulator.jobs.Job;

import java.util.List;

/**
 * Created by sagarjani on 15/2/18.
 */
public interface JobModelLoader {

    List<Job> load();
}

package com.sagarj.robot.toyrobotsimulator.queue;

import com.sagarj.robot.toyrobotsimulator.jobs.Job;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sagarjani on 15/2/18.
 */
@Component
public class ToyRobotCommandQueue extends PriorityQueue<Job> {

    private static Comparator<Job> jobComparator = new Comparator<Job>() {

        @Override public int compare(Job job1, Job job2) {
            return job1.getPriority() - job2.getPriority();
        }
    };
    public ToyRobotCommandQueue() {
        super(10,jobComparator);
    }
}

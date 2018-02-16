package com.sagarj.robot.toyrobotsimulator.executor;

import com.sagarj.robot.toyrobotsimulator.ToyRobotSimulator;
import com.sagarj.robot.toyrobotsimulator.jobs.Job;
import com.sagarj.robot.toyrobotsimulator.model.JobModelLoader;
import com.sagarj.robot.toyrobotsimulator.queue.ToyRobotCommandQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sagarjani on 15/2/18.
 */
@Component
public class ToyRobotCommandExecutor implements Runnable {

    private static Log logger = LogFactory.getLog(ToyRobotCommandExecutor.class);

    @Autowired
    ToyRobotCommandQueue toyRobotCommandQueue;

    @Autowired
    JobModelLoader jobModelLoader;

    @Autowired
    ToyRobotCommandQueue commandQueue;

    @Autowired
    ToyRobotSimulator toyRobotSimulator;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run() {


        //load all the jobs
        List<Job> jobs = jobModelLoader.load();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            //Left blank intentionally as
        }

        logger.info("=== Queuing jobs ===");
        commandQueue.addAll(jobs);

        logger.info("=== Executing Jobs ===");

        execute();

        logger.info("=== Execution Completed ===");

        SpringApplication.exit(applicationContext);
    }

    public void execute() {
        while (!toyRobotCommandQueue.isEmpty()) {
            Job job = toyRobotCommandQueue.poll();
            job.execute(toyRobotSimulator);
        }
    }
}

package com.sagarj.robot.toyrobotsimulator.jobs;

import com.sagarj.robot.toyrobotsimulator.ToyRobotSimulator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by sagarjani on 14/2/18.
 */
public class ReportJob implements Job {

    private static final Log logger = LogFactory.getLog(ReportJob.class);

    //todo: format the outputs
    @Override
    public void execute(ToyRobotSimulator toyRobotSimulator) {
        logger.info("Coordinates :" + toyRobotSimulator.currentLocation());
    }

    @Override
    public int getPriority() {
        return JobPriority.REPORT.getPriority();
    }

}

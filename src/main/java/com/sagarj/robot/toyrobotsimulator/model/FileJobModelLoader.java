package com.sagarj.robot.toyrobotsimulator.model;

import com.sagarj.robot.toyrobotsimulator.jobs.Job;
import com.sagarj.robot.toyrobotsimulator.parser.JobParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sagarjani on 15/2/18.
 */
@Component
public class FileJobModelLoader implements JobModelLoader {

    private static Log logger = LogFactory.getLog(FileJobModelLoader.class);

    @Autowired
    JobParser jobParser;


    @Value("#{'${Commands}'.split(',')}")
    List<String> strCommands;

    @Override
    public List<Job> load() {

        List<Job> jobs = new ArrayList<>();

        logger.info("=== Loading jobs from application.yml ===");

        for (String command : strCommands) {
            jobs.add(jobParser.parseJob(command));
        }

        return jobs;
    }


}

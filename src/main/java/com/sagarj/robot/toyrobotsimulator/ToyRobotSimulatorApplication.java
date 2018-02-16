package com.sagarj.robot.toyrobotsimulator;

import com.sagarj.robot.toyrobotsimulator.executor.ToyRobotCommandExecutor;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Coordinates;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Direction;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Grid;
import com.sagarj.robot.toyrobotsimulator.model.FileJobModelLoader;
import com.sagarj.robot.toyrobotsimulator.queue.ToyRobotCommandQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@SpringBootApplication
public class ToyRobotSimulatorApplication {

    private static Log logger = LogFactory.getLog(ToyRobotSimulatorApplication.class);

    @Autowired
    ToyRobotCommandExecutor commandExecutor;

    public static void main(String[] args) {
        SpringApplication.run(ToyRobotSimulatorApplication.class, args);
    }

    @Bean
    public ToyRobotSimulator toyRobotSimulator() {
        return new ToyRobotSimulator(grid(), Direction.SOUTH, coordinates());
    }

    @Bean
    public Coordinates coordinates() {
        return new Coordinates(0, 0);
    }

    @Bean
    public Grid grid() {
        return new Grid(5, 5);
    }

    @Bean
    public ServletContextListener listener() {
        return new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent servletContextEvent) {
                logger.info("ServletContext Initialized");
                new Thread(commandExecutor).start();
            }

            @Override
            public void contextDestroyed(ServletContextEvent servletContextEvent) {

            }
        };
    }

    @Bean
    public ToyRobotCommandExecutor toyRobotCommandExecutor() {
        return new ToyRobotCommandExecutor();
    }

    @Bean
    public ToyRobotCommandQueue toyRobotCommandQueue() {
        return new ToyRobotCommandQueue();
    }

    @Bean
    public FileJobModelLoader fileJobModelLoader() {
        return new FileJobModelLoader();
    }

}

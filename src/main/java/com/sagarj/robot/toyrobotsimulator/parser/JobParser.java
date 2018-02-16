package com.sagarj.robot.toyrobotsimulator.parser;

import com.sagarj.robot.toyrobotsimulator.gridobjects.Coordinates;
import com.sagarj.robot.toyrobotsimulator.gridobjects.Direction;
import com.sagarj.robot.toyrobotsimulator.jobs.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JobParser {

    private static final String PLACE = "PLACE";

    private static PlaceJob placeCommand;
    private static String SPLIT_CHARACTER = " ";

    private static Map<String, Job> stringToCommandMap = new HashMap<String, Job>() {{
        put("PLACE", placeCommand);
        put("LEFT", new RotateLeftJob());
        put("RIGHT", new RotateRightJob());
        put("MOVE", new MoveJob());
        put("REPORT", new ReportJob());
    }};

    private static Map<String, Direction> stringToDirectionMap = new HashMap<String, Direction>() {
        {
            put("EAST", Direction.EAST);
            put("WEST", Direction.WEST);
            put("NORTH", Direction.NORTH);
            put("SOUTH", Direction.SOUTH);
        }
    };

    /*private String commandString;*/

    public JobParser() {
    }

    /**
     * This method parses the String jobs into a command object.
     *
     * @return
     */
    public Job parseJob(String commandString) {
        if (validateCommands(commandString)) {
            return lookUpCommand(commandString);
        }
        return null;
    }

    private boolean validateCreateInitCommand(String commandString) {
        String[] commandSplit = commandString.split(SPLIT_CHARACTER);
        if (commandSplit.length == 4
                && commandSplit[1].matches("^-?\\d+$")
                && commandSplit[2].matches("^-?\\d+$")
                && stringToDirectionMap.keySet().contains(
                commandSplit[3].toUpperCase())) {

            placeCommand = new PlaceJob(stringToDirectionMap.get(commandSplit[3]
                    .toUpperCase()), new Coordinates(
                    Integer.parseInt(commandSplit[1]),
                    Integer.parseInt(commandSplit[2])));
            stringToCommandMap.put(PLACE, placeCommand);
            return true;
        }

        return false;
    }

    private boolean validateCommands(final String commandString) {
        if (commandString.trim().startsWith(JobParser.PLACE)) {
            return validateCreateInitCommand(commandString);
        } else {
            return stringToCommandMap.containsKey(commandString.trim());
        }
    }

    private Job lookUpCommand(final String commandString) {
        return stringToCommandMap.get(commandString.split(SPLIT_CHARACTER)[0]);

    }
}

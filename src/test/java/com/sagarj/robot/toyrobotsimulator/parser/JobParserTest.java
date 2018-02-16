package com.sagarj.robot.toyrobotsimulator.parser;

import com.sagarj.robot.toyrobotsimulator.jobs.*;
import org.junit.Assert;
import org.junit.Test;

public class JobParserTest {

	@Test
	public void stringToPlaceCommandMapping() {
		JobParser parser = new JobParser();

		Job command = parser.parseJob("PLACE 0 0 North");

		Assert.assertTrue(command instanceof PlaceJob);
	}

	@Test
	public void stringLMapsToRotateLeftCommand() {

		JobParser parser = new JobParser();

		Job command = parser.parseJob("LEFT");

		Assert.assertTrue(command instanceof RotateLeftJob);

	}

	@Test
	public void stringRMapsToRotateRightCommand() {
		// Given
		JobParser parser = new JobParser();

		// When
		Job command = parser.parseJob("RIGHT");

		// Then
		Assert.assertTrue(command instanceof RotateRightJob);
	}

	@Test
	public void stringMapsToReportCommand() {
		// Given
		JobParser parser = new JobParser();

		// When
		Job command = parser.parseJob("REPORT");

		// Then
		Assert.assertTrue(command instanceof ReportJob);
	}

	@Test
	public void stringMapsToForewardCommand() {
		// Given
		JobParser parser = new JobParser();

		// When
		Job command = parser.parseJob("MOVE");

		// Then
		Assert.assertTrue(command instanceof MoveJob);

	}

}

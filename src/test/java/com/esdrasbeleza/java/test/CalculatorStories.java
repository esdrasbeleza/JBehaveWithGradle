package com.esdrasbeleza.java.test;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class CalculatorStories extends JUnitStories {
	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/test/resources"), 
				"**/*.story",
				"**/exclude_*.story");
	}
	
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
		.useStoryLoader(new LoadFromClasspath(this.getClass()))
		.useStoryReporterBuilder(new StoryReporterBuilder()
		.withFormats(Format.XML, Format.IDE_CONSOLE, Format.CONSOLE, Format.HTML, Format.TXT)
		/*
		 *  The default output for the tests require is Maven's "target" folder,
		 *  since we're using Gradle we will set it to target/../build/jbehave 
		 */
		.withRelativeDirectory("../build/jbehave/"));
	}

	@Override
    public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new CalculatorSteps()); 
	}

}

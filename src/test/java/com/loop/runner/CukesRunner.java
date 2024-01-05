package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/loop/step_definitions"
)

public class CukesRunner {

}

/**
 * We write Scenarios in the Feature class,
 * create snippets in the regular Java class
 * in the step_definition package,
 * and RUN the code in another
 * Java class which is in the runner package.
 */


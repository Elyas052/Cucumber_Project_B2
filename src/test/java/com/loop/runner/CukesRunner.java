package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// RunWith comes from JUnit and triggers the execution of the test.
@RunWith(Cucumber.class)
@CucumberOptions(
        // To generate a report in html format.
        plugin = {"html:target/html-reports/cucumber-report.html",
                // To generate a report in JSON format.
                "json:target/json-reports/json-report.json"},
        // This is for the failed test report.
        // "rerun:target/rerun.txt"},
        // Path to feature file
        features = "src/test/resources/features",
        // Path to step definition classes
        glue = "com/loop/step_definitions",
        tags = "@smoke",
        // It can be true or false. When dryRun=true, Hook Class and any browser will not run.
        dryRun = false,
        // Make console output for the Cucumber test much more readable and remove any unreadable character.
        monochrome = true
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

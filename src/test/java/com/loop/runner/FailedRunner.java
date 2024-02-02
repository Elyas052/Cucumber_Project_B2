/**
 * JUnit Runner class for running failed Cucumber scenarios.
 * The CucumberOptions annotation is configured to generate reports in HTML and JSON formats.
 * It specifies the location of the rerun.txt file to rerun the failed scenarios.
 * The glue option points to the package where step definitions are located.
 * The monochrome option ensures that the console output is more readable.
 * The publication option is set too false to prevent publishing results to the Cucumber dashboard.
 */
package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-report.html",
                "json:target/json-reports/json-report.json"},
        features = "@target/rerun.txt",
        glue = "com/loop/step_definitions",
        monochrome = true,
        publish = false
)
public class FailedRunner {
}

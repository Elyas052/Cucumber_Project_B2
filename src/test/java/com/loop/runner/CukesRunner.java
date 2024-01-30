/**
 * Cucumber test runner class for executing feature files and generating reports.
 */
package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// mvn test -Dcucumber.filter.tags=@multiThread

@RunWith(Cucumber.class)
@CucumberOptions(
        // Define plugins for generating different types of reports
        plugin = {"html:target/html-reports/cucumber-report.html",
                "json:target/json-reports/json-report.json",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

        // Specify the location of feature files
        features = "src/test/resources/features",

        // Specify the package where step definitions are located
        glue = "com/loop/step_definitions",

        // Disable dry run (actual execution of steps)
        dryRun = false,

        // Run scenarios with the specified tags
        tags = "@multiThread",

        // Display console output in monochrome format
        monochrome = true,

        // Do not publish the results
        publish = false
)
public class CukesRunner {
}

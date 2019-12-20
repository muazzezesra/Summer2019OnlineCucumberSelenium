package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features", // path to features
        glue = "com\\vytrack\\step_definitions", // path to step definitions
        dryRun = false,
        tags = "@driver_with_data_table",
        plugin = {"html:target/default-cucumber-reports",
                  "json:target/cucumber.json"}
)

public class CucumberRunner {

}

/*
 how do you run specific feature not others? (interviewer)
Answer: using specific tag or locating its path like >>  "src\\test\\resources\\features\\activities\\CalendarEvents.feature"
 features = {
           "src\\test\\resources\\features\\fleet"
           "src\\test\\resources\\features\\activities
            }
 Another solution to test what u want


 tags = "~ @negative_test" just this tag's tests will run
 tags = "not @negative_test" don't run only this tag
 tags = "@negative_test and @driver" must have exactly these tags to be able to run, other will not run
 tags = "@negative_test or @driver" only either one of em gonna execute
 tags = "" every test will run
 */

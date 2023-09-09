package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/resources/features/smt.feature", glue = "stepDefinition",
monochrome = true,
plugin = {"pretty","html:target/HTMLReport.html"})
public class TestRunner {

}

package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepDef"},tags = ("@B.E2E"),plugin = {"html:target/cucumber-report/html-report.html"}
		)
public class Runner extends AbstractTestNGCucumberTests {

}

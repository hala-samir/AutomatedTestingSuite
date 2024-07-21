package runner;

import io.cucumber.testng.CucumberOptions;
import stepdefinitions.TestBase;


@CucumberOptions(
        features = "src/test/resourses",
        glue = {"stepdefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-html-report"},
        tags = "@test",
        monochrome = true
)
public class TestRunner extends TestBase {
}

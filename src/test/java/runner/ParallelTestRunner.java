package runner;

import io.cucumber.testng.CucumberOptions;
import stepdefinitions.TestBase;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resourses/features/03.SendContactMsg.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-html-report"},
        tags = "@contact",
        monochrome = true
)

public class ParallelTestRunner extends TestBase {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
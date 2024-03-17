package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/user_api.feature",
        glue = "StepDefs",
        monochrome = true
)
public class UserAPI extends AbstractTestNGCucumberTests {
}

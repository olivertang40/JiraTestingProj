package Runners;

import Drivers.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = "src/test/resources/features/create_sprint_ui.feature",
        glue = "StepDefs"
)
public class CreateSprintUI extends AbstractTestNGCucumberTests {

}

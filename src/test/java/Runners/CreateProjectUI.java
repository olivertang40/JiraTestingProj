package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/create_scrum_project_ui.feature",
        glue = "StepDefs",
        monochrome = true
)
public class CreateProjectUI extends AbstractTestNGCucumberTests {
}

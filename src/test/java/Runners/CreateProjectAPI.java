package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/create_scrum_project_api.feature",
        glue = "ProjectManagement",
        monochrome = true
)

public class CreateProjectAPI extends AbstractTestNGCucumberTests {

}
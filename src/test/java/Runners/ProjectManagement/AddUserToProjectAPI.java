package Runners.ProjectManagement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/add_user_to_project_api.feature",
        glue = "StepDefs.ProjectManagement"
)
public class AddUserToProjectAPI extends AbstractTestNGCucumberTests {
}

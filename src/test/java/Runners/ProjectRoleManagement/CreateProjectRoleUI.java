package Runners.ProjectRoleManagement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/create_project_role_ui.feature",
        glue = "StepDefs"
)
public class CreateProjectRoleUI extends AbstractTestNGCucumberTests {
}

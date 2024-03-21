package Runners.ProjectRoleManagement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/add_user_to_role_ui.feature",
        glue = "StepDefs"
)
public class AddUserToRoleUI extends AbstractTestNGCucumberTests {
}

package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/get_users_by_roles_api.feature"
)
public class GetUsersByRolesAPI extends AbstractTestNGCucumberTests {
}

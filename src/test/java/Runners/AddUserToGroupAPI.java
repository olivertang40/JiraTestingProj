package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/add_user_to_group_api.feature"
)
public class AddUserToGroupAPI extends AbstractTestNGCucumberTests {
}

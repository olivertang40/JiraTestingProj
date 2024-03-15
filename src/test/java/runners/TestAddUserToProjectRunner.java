package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/AddUserToProject.feature"
)
public class TestAddUserToProjectRunner extends AbstractTestNGCucumberTests {
}

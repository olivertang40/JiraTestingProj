package project_management;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/CreateScrumProject.feature"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/CreateScrumPorjectUI.feature",
        glue = "project_management",
        monochrome = true
)
public class TestCreateProjectUIRunner extends AbstractTestNGCucumberTests {
}
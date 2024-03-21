package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/workflow_ui.feature",
        glue = "StepDefs",
        monochrome = true
)
public class WorkflowUI extends AbstractTestNGCucumberTests {
}

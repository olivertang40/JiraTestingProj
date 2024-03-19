package Runners.IssueManagement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/create_issue_api.feature",
        glue = "StepDefs.IssueManagement",
        monochrome = true
)
public class CreateIssueAPI extends AbstractTestNGCucumberTests {
}

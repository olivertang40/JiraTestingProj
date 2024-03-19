package Runners.IssueManagement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/assign_issue_api.feature",
        glue = "StepDefs.IssueManagement",
        monochrome = true
)
public class AssignIssueAPI extends AbstractTestNGCucumberTests {
}

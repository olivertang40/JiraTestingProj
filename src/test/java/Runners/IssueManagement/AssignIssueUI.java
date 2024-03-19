package Runners.IssueManagement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/assign_issue_ui.feature",
        glue = "StepDefs.IssueManagement",
        monochrome = true
)
public class AssignIssueUI extends AbstractTestNGCucumberTests {
}

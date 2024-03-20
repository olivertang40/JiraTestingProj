package Runners.IssueManagement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features/view_my_issue_api.feature",
        glue = "src/test/java/stepDef/issueManagement"
)
public class ViewMyIssueAPI extends AbstractTestNGCucumberTests {
}

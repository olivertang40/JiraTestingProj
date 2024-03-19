package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/move_issue_to_new_sprint_ui.feature",
        glue = "StepDefs"
)

public class MoveIssueUI extends AbstractTestNGCucumberTests {

}

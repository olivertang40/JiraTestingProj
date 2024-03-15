package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/groupManage.feature"
//        glue = {"stepDef", "page_object_model"}
)

public class TestRunnerGroupUi extends AbstractTestNGCucumberTests {

}

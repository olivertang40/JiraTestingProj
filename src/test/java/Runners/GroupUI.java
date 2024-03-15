package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/group_manage_ui.feature"
//        glue = {"stepDef", "page_object_model"}
)

public class GroupUI extends AbstractTestNGCucumberTests {

}

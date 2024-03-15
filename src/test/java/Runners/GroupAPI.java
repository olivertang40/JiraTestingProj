package Runners;

import Drivers.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = "src/test/resources/group_manage_api.feature",
        glue = {"StepDefs", "PageObjectModel"}
)
public class GroupAPI extends AbstractTestNGCucumberTests {

    @AfterTest
    public void quitBrowser() {
        DriverFactory.getDriver().quit();
    }
}

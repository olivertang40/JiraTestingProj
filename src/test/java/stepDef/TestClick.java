package stepDef;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClick extends Base {

    @BeforeClass
    @Override
    public void setup(){
        super.setup();
        driver.navigate().to("file://" + System.getProperty("user.dir") + "/src/test/java/js_executor/scroll/scroll-demo.html");
    }

    @Test
    public void testScrollDownAndRight(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(150, 300)");
        System.out.println();
    }
}

package Drivers;

import Utils.ApplicationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private static void setupDriver() {
        switch (ApplicationProperties.get("browserType").toLowerCase()) {
            case "edge": {
                WebDriverManager.edgedriver().clearDriverCache().setup();
                webDriver.set(new EdgeDriver());
                break;
            }
            case "chrome": {
                WebDriverManager.chromedriver().clearDriverCache().setup();
                webDriver.set(new ChromeDriver());
                break;
            }
            default: {
                System.out.println("Browser type is not supported!");
            }
        }
        webDriver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            setupDriver();
        }
        return webDriver.get();
    }

    public static void teardown(){
        if(webDriver.get() != null){
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}



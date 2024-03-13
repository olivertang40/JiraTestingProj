package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driverlocal = new ThreadLocal<>();

    private static WebDriver createWebDriver(){
        WebDriver webDriver;
        try(FileInputStream input = new FileInputStream("src/test/resources/application.properties")){
            Properties properties = new Properties();
            properties.load(input);

            switch (properties.getProperty("driver").toLowerCase()){
                case "chrome":{
                    WebDriverManager.chromedriver().clearDriverCache().setup();
                    webDriver = new ChromeDriver();
                    break;
                }
                case "edge":{
                    WebDriverManager.edgedriver().clearDriverCache().setup();
                    webDriver = new EdgeDriver();
                    break;
                }
                default:{
                    throw new IllegalArgumentException("browser type is not supported!");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return webDriver;
    }

    public static WebDriver getDriver(){
        if(driverlocal.get() == null){
            driverlocal.set(createWebDriver());
        }
        return driverlocal.get();
    }

    public static void teardown(){
        if(driverlocal.get() != null){
            driverlocal.get().quit();
            driverlocal.remove();
        }
    }
}

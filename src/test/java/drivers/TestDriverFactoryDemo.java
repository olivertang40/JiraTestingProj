package drivers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestDriverFactoryDemo {

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void testDriverFactory() throws InterruptedException {
        Thread thread = new Thread(() -> {
            WebDriver driver = DriverFactory.getDriver();
            System.out.println(driver);
            System.out.println(Thread.currentThread().getId());
        });
        // start the thread
        thread.start();
        // main thread will be blocked until the current thread finishes
        thread.join();
    }
}

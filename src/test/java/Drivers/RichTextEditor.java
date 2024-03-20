package Drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RichTextEditor {
    // Use to switch between the driver and the iframe
    private WebDriver driver;
    private String iframeClass;

    public RichTextEditor(WebDriver driver, String iframeClass) {
        this.driver = driver;
        this.iframeClass = iframeClass;
    }

    public void enterText(String text) {
        // Find the iframe by its class and switch to it
        WebElement iframe = driver.findElement(By.className(iframeClass));
        driver.switchTo().frame(iframe);

        // Enter text into the rich text editor
        WebElement editor = driver.findElement(By.tagName("body"));
        editor.sendKeys(text);

        // Switch back to the main document
        driver.switchTo().defaultContent();
    }
}
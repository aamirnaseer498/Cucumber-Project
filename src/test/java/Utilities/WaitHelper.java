package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    public WaitHelper(WebDriver webDriver){
        this.webDriver= webDriver;
    }

    public void waitForElement(WebElement webElement, long timeOutSeconds){
        webDriverWait= new WebDriverWait(webDriver, Duration.ofSeconds(timeOutSeconds));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

}

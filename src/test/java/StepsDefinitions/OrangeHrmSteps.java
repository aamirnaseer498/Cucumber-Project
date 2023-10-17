package StepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHrmSteps {

    WebDriver webDriver;

    @Given("Launch chrome browser")
    public void launchChromeBrowser() {
        webDriver = new ChromeDriver();
    }

    @When("Open orangehrm homepage")
    public void openOrangehrmHomepage() {
        webDriver.manage().window().maximize();
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Then("Verify that the logo present on page")
    public void verifyThatTheLogoPresentOnPage() {
        WebDriverWait driverWait= new WebDriverWait(webDriver, Duration.ofSeconds(10000));
        WebElement logoElement= driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
        Assert.assertEquals("Logo is not displayed",true,logoElement.isDisplayed());
    }

    @And("Close browser")
    public void closeBrowser() {
        webDriver.close();
    }

}

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
    WebDriverWait driverWait;
    WebElement logoElement;

    @Given("Launch chrome browser")
    public void launch_chrome_browser() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        System.out.println("Browser opened");
    }

    @When("Open orangehrm homepage")
    public void open_orangehrm_homepage() {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Homepage opened");
    }

    @Then("Verify that the logo present on page")
    public void verify_that_the_logo_present_on_page() {
        driverWait= new WebDriverWait(webDriver, Duration.ofSeconds(10000));
        logoElement= driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
        Assert.assertEquals("Logo is not displayed",true,logoElement.isDisplayed());
        System.out.println("Logo is present");
    }

    @Then("Close browser")
    public void close_browser() {
        webDriver.close();
        System.out.println("Browser closed");
    }

}

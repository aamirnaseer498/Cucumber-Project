package PageObjects;

import Utilities.WaitHelper;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPage {

    public WebDriver webDriver;
    public WaitHelper waitHelper;

    @FindBy(xpath = "//input[@id='SearchEmail']")
    @CacheLookup
    WebElement emailField;
    @FindBy(xpath = "//input[@id='SearchFirstName']")
    @CacheLookup
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='SearchLastName']")
    @CacheLookup
    WebElement lastNameField;
    @FindBy(id = "search-customers")
    @CacheLookup
    WebElement searchButton;
    @FindBy(xpath = "//table[@role='grid']")
    @CacheLookup
    WebElement tableSearchResults;
    @FindBy(xpath = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;
    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List <WebElement> tableRows;
    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List <WebElement> tableColumns;

    public SearchCustomerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
        waitHelper= new WaitHelper(webDriver);
    }

    public void enterEmail(String email){
        waitHelper.waitForElement(emailField,60);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterFirstName(String firstName){
        waitHelper.waitForElement(firstNameField,60);
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        waitHelper.waitForElement(lastNameField,60);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void clickSearchButton(){
        waitHelper.waitForElement(searchButton,60);
        searchButton.click();
    }

    public int getTableRows(){
        return tableRows.size();
    }

    public int getTableColumns(){
        return tableColumns.size();
    }

    public boolean searchCustomerByEmail(String email){
        waitHelper.waitForElement(table,60);

        boolean flag= false;

        for (int i=1; i<=tableRows.size(); i++) {
            String foundedEmail= webDriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("Provided Email: " + email);
            System.out.println("Founded Email: " + foundedEmail);
            if (foundedEmail.equals(email)){
                flag= true;
                break;
            }

        }
        return flag;
    }

    public boolean searchCustomerByName(String name){
        waitHelper.waitForElement(table,60);

        boolean flag= false;

        for (int i=1; i<=tableRows.size(); i++) {
            String foundedName= webDriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
            System.out.println("Provided Name: " + name);
            System.out.println("Founded Name: " + foundedName);
            if (foundedName.equals(name)){
                flag= true;
                break;
            }

        }
        return flag;
    }

}

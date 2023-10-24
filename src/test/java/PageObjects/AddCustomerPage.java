package PageObjects;

import Utilities.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

    WebDriver webDriver;
    WaitHelper waitHelper;
    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    @CacheLookup
    WebElement customersMenuLink;
    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
    @CacheLookup
    WebElement customersMenuItemLink;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    @CacheLookup
    WebElement addNewButton;
    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    WebElement emailField;
    @FindBy(xpath = "//input[@id='Password']")
    @CacheLookup
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='FirstName']")
    @CacheLookup
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='LastName']")
    @CacheLookup
    WebElement lastNameField;
    @FindBy(xpath = "//label[@for='Gender_Male']")
    @CacheLookup
    WebElement maleGenderRadioButton;
    @FindBy(xpath = "//label[@for='Gender_Female']")
    @CacheLookup
    WebElement femaleGenderRadioButton;
    @FindBy(xpath = "//input[@id='DateOfBirth']")
    @CacheLookup
    WebElement dateOfBirthField;
    @FindBy(xpath = "//input[@id='Company']")
    @CacheLookup
    WebElement companyNameField;
    @FindBy(xpath = "//input[@id='IsTaxExempt']")
    @CacheLookup
    WebElement taxExemptCheckBoxButton;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]")
    @CacheLookup
    WebElement newsLetterField;
    @FindBy(xpath = "//li[@id='bdb515e5-bee0-4112-92f5-a9160c3e64e9']")
    @CacheLookup
    WebElement newsLetterListItemYourStoreName;
    @FindBy(xpath = "//li[normalize-space()='Test store 2']")
    @CacheLookup
    WebElement newsLetterListItemTestStore2;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]")
    @CacheLookup
    WebElement customerRolesField;
    @FindBy(xpath = "//li[normalize-space()='Administrators']")
    @CacheLookup
    WebElement customerRolesListItemAdministrators;
    @FindBy(xpath = "//li[normalize-space()='Forum Moderators']")
    @CacheLookup
    WebElement customerRolesListItemForumModerators;
    @FindBy(xpath = "//li[normalize-space()='Guests']")
    @CacheLookup
    WebElement customerRolesListItemGuests;
    @FindBy(xpath = "//li[@id='2b0f7d70-6948-4899-8f0a-9f3801447265']")
    @CacheLookup
    WebElement customerRolesListItemRegistered;
    @FindBy(xpath = "//li[contains(text(),'Vendors')]")
    @CacheLookup
    WebElement customerRolesListItemVendors;
    @FindBy(xpath = "//select[@id='VendorId']")
    @CacheLookup
    WebElement managerOfVendorDropDown;
    @FindBy(xpath = "//input[@id='Active']")
    @CacheLookup
    WebElement activeCheckBoxButton;
    @FindBy(xpath = "//textarea[@id='AdminComment']")
    @CacheLookup
    WebElement adminCommentField;
    @FindBy(xpath = "//button[@name='save']")
    @CacheLookup
    WebElement saveButton;

    public AddCustomerPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
        waitHelper = new WaitHelper(webDriver);
    }

    public void clickOnCustomersMenuLink(){
        waitHelper.waitForElement(customersMenuLink,60);
        customersMenuLink.click();
    }

    public void clickOnCustomersMenuItemLink(){
        waitHelper.waitForElement(customersMenuItemLink,60);
        customersMenuItemLink.click();
    }

    public void clickOnAddNewButton(){
        waitHelper.waitForElement(addNewButton,60);
        addNewButton.click();
    }

    public void enterEmail(String email){
        waitHelper.waitForElement(emailField,60);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        waitHelper.waitForElement(passwordField,60);
        passwordField.clear();
        passwordField.sendKeys(password);
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

    public void selectGender(String gender){
        if (gender.equals("Male")){
            waitHelper.waitForElement(maleGenderRadioButton,60);
            maleGenderRadioButton.click();
        }else if (gender.equals("Female")){
            waitHelper.waitForElement(femaleGenderRadioButton,60);
            femaleGenderRadioButton.click();
        }
    }

    public void enterDateOfBirth(String dateOfBirth){
        waitHelper.waitForElement(dateOfBirthField,60);
        dateOfBirthField.clear();
        dateOfBirthField.sendKeys(dateOfBirth);
    }

    public void enterCompanyName(String companyName){
        waitHelper.waitForElement(companyNameField,60);
        companyNameField.clear();
        companyNameField.sendKeys(companyName);
    }

    public void isTaxExempt(){
        waitHelper.waitForElement(taxExemptCheckBoxButton,60);
        taxExemptCheckBoxButton.click();
    }

    public void selectNewsLetter(String newsLetter){
        waitHelper.waitForElement(newsLetterField,60);
        newsLetterField.click();
        if (newsLetter.equals("Your store name")){
            waitHelper.waitForElement(newsLetterListItemYourStoreName,60);
            newsLetterListItemYourStoreName.click();
        }else if (newsLetter.equals("Test store 2")){
            waitHelper.waitForElement(newsLetterListItemTestStore2,60);
            newsLetterListItemTestStore2.click();
        }
    }

    public void selectCustomerRoles(String role){
        waitHelper.waitForElement(customerRolesField,60);
        customerRolesField.click();
        if (role.equals("Administrators")){
            waitHelper.waitForElement(customerRolesListItemAdministrators,60);
            customerRolesListItemAdministrators.click();
        }else if (role.equals("Forum Moderators")){
            waitHelper.waitForElement(customerRolesListItemForumModerators,60);
            customerRolesListItemForumModerators.click();
        }else if (role.equals("Guests")){
            waitHelper.waitForElement(customerRolesListItemGuests,60);
            customerRolesListItemGuests.click();
        }else if (role.equals("Registered")){
            waitHelper.waitForElement(customerRolesListItemRegistered,60);
            customerRolesListItemRegistered.click();
        }else if (role.equals("Vendors")){
            waitHelper.waitForElement(customerRolesListItemVendors,60);
            customerRolesListItemVendors.click();
        }
    }

    public void selectManagerOfVendor(String vendor){
        waitHelper.waitForElement(managerOfVendorDropDown,60);
        Select option= new Select(managerOfVendorDropDown);
        option.selectByVisibleText(vendor);
    }

    public void isActive(){
        waitHelper.waitForElement(activeCheckBoxButton,60);
        activeCheckBoxButton.click();
    }

    public void enterAdminComment(String adminComment){
        waitHelper.waitForElement(adminCommentField,60);
        adminCommentField.clear();
        adminCommentField.sendKeys(adminComment);
    }

    public void submitCustomer(){
        waitHelper.waitForElement(saveButton,60);
        saveButton.click();
    }

}

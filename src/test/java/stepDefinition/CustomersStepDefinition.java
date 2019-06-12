package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.CustomerInformation;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.HomePage;

public class CustomersStepDefinition {
	public static WebDriver driver;

    @Given("^I open the grocery crud website$")
    public void openGroceryPage() {         	
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
    }
    
    @When("^I create a new customer$")
    public void createNewCustomer() {
    	HomePage home = new HomePage(driver);
    	AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
    	CustomerInformation customerInformation = new CustomerInformation();
    	home.getVersionSelect().selectByVisibleText("Bootstrap V4 Theme");
    	home.getAddCustomerButton().click();

    	addCustomerPage.getCustomerNameField().sendKeys(customerInformation.getName());
    	addCustomerPage.getCustomerLastNameField().sendKeys(customerInformation.getLastName());
    	addCustomerPage.getContactFirstNameField().sendKeys(customerInformation.getContactFirstName());
    	addCustomerPage.getPhoneField().sendKeys(customerInformation.getPhone());
    	addCustomerPage.getAddressLine1Field().sendKeys(customerInformation.getAddressLine1());
    	addCustomerPage.getAddressLine2Field().sendKeys(customerInformation.getAddressLine2());
    	addCustomerPage.getCityField().sendKeys(customerInformation.getCity());
    	addCustomerPage.getStateField().sendKeys(customerInformation.getState());
    	addCustomerPage.getPostalCodeField().sendKeys(customerInformation.getPostalCode());
    	addCustomerPage.getCountryField().sendKeys(customerInformation.getCountry());
    	addCustomerPage.getFromEmployeerLabel().click();
    	addCustomerPage.getFromEmployeerSearchField().sendKeys(customerInformation.getFromEmployeer());
    	addCustomerPage.getFromEmployeerSearchField().sendKeys(Keys.ENTER);
    	addCustomerPage.getCreditLimitField().sendKeys(customerInformation.getCreditLimit());
    	addCustomerPage.getSaveButton().click();
    }

	@Then("^I can see the message (.*) on the screen$")
    public void checkSuccessMessage(String expectedMessage) {
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(addCustomerPage.getSuccessMessageText(), expectedMessage));
    }
	
	@Given("^I add a new customer$")
    public void addNewCustomer() {         	
        openGroceryPage();
        createNewCustomer();
    }
    
    @When("^I search for a customer and delete it with the message (.*)$")
    public void searchCustomer(String expectedMessage) {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	HomePage home = new HomePage(driver);
    	AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
    	CustomerInformation customerInformation = new CustomerInformation();
    	addCustomerPage.getGoBackLink().click();
    	home.getSearchButton().click();
    	home.getSearchInput().sendKeys(customerInformation.getName());
    	home.getSearchInput().sendKeys(Keys.ENTER);
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(home.getLoadingText()));
    	home.getSelectAllCustomersCheckbox().click();
    	home.getDeleteButton().click();
    	
		wait.until(ExpectedConditions.textToBePresentInElementLocated(home.getDeleteConfirmationText(), expectedMessage));
		home.getPopUpDeleteButton().click();
    }
    
    @Then("^I can see the message (.*) on an alert$")
    public void checkAlertSuccessMessage(String expectedMessage) {
    	HomePage home = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(home.getDeletionSuccessText(), expectedMessage));
    }

    @After
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }
    
}

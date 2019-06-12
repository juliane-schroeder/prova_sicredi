package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCustomerPage {
	public final WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCustomerNameField() {
		return driver.findElement(By.id("field-customerName"));
	}
	
	public WebElement getCustomerLastNameField() {
		return driver.findElement(By.id("field-contactLastName"));
	}
	
	public WebElement getContactFirstNameField() {
		return driver.findElement(By.id("field-contactFirstName"));
	}
	
	public WebElement getPhoneField() {
		return driver.findElement(By.id("field-phone"));
	}

	public WebElement getAddressLine1Field() {
		return driver.findElement(By.id("field-addressLine1"));
	}
	
	public WebElement getAddressLine2Field() {
		return driver.findElement(By.id("field-addressLine2"));
	}
	
	public WebElement getCityField() {
		return driver.findElement(By.id("field-city"));
	}
	
	public WebElement getStateField() {
		return driver.findElement(By.id("field-state"));
	}
	
	public WebElement getPostalCodeField() {
		return driver.findElement(By.id("field-postalCode"));
	}
	
	public WebElement getCountryField() {
		return driver.findElement(By.id("field-country"));
	}
	
	public WebElement getFromEmployeerLabel() {
		return driver.findElement(By.id("field_salesRepEmployeeNumber_chosen"));
	}
	
	public WebElement getFromEmployeerSearchField() {
		return driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input"));
	}
	
	public WebElement getCreditLimitField() {
		return driver.findElement(By.id("field-creditLimit"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("form-button-save"));
	}
	
	public By getSuccessMessageText() {
		return By.id("report-success");
	}
	
	public WebElement getGoBackLink() {
		return driver.findElement(By.xpath("//*[@id=\"report-success\"]/p/a[2]"));
	}
}

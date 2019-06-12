package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	public final WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Select getVersionSelect() {
		return new Select(driver.findElement(By.id("switch-version-select")));
	}
	
	public WebElement getAddCustomerButton() {
		return driver.findElement(By.cssSelector("a[class='btn btn-default btn-outline-dark']"));
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(By.className("search-button"));
	}
	
	public WebElement getSearchInput() {
		return driver.findElement(By.className("search-input"));
	}
	
	public WebElement getSelectAllCustomersCheckbox() {
		return driver.findElement(By.className("select-all-none"));
	}
	
	public WebElement getDeleteButton() {
		return driver.findElement(By.className("delete-selected-button"));
	}
	
	public By getLoadingText() {
		return By.className("loading-opacity");
	}
	
	public WebElement getPopUpDeleteButton() {
		return driver.findElement(By.className("delete-multiple-confirmation-button"));
	}
	
	public By getDeleteConfirmationText() {
		return By.className("alert-delete-multiple-one");
	}
	
	public By getDeletionSuccessText() {
		return By.className("alert-success");
	}
}

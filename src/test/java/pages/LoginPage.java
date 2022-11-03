package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver; // driver is null

	public LoginPage(WebDriver rdriver) {

		// this.driver= driver; // this keyword is for if both the drivers are same

		driver = rdriver;
	}

	// identification
	By txtEmail = By.id("Email");
	By txtPass = By.cssSelector("input#Password");
	By chkRememberMe = By.cssSelector("input#RememberMe");
	By btnLogin = By.tagName("button");
	By btnLogout = By.linkText("Logout");

	// methods/actions
	public void enterEmail(String email) {
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);

	}

	public void enterPass(String pwd) {
		driver.findElement(txtPass).clear();
		driver.findElement(txtPass).sendKeys(pwd);
	}

	public void clickCheckBox() {
		driver.findElement(chkRememberMe).click();
	}

	public void clickLoginButton() {
		driver.findElement(btnLogin).click();
	}

	public void clickLogout() {
		driver.findElement(btnLogout).click();
	}

	public void clickOnWebElement(WebElement ele) {
		ele.click();
	}

	public void verifyAppTitle(String expValue) {
		Assert.assertEquals(driver.getTitle(), expValue);
	}

}

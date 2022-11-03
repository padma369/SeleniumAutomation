package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AnotherApproachLoginPagePOM {

	WebDriver driver; // driver is null

	public AnotherApproachLoginPagePOM(WebDriver rdriver) {
     driver = rdriver;
   PageFactory.initElements(rdriver, this);     //using this keyword bcoz its a constructor. and class name method name is same both have drivers
 }

	// Identification
	@FindBy(id = "Email")
	WebElement txt_Email;
	@FindBy(css = "input#Password")
	WebElement txt_Pass;
	@FindBy(css = "input#RememberMe") /// prop.getProperty("remmbercheckbox")
	WebElement chk_RememberMe;
	@FindBy(tagName = "button")
	WebElement btn_Login;
	@FindBy(linkText = "Logout")
	WebElement btn_Logout;

	// Actions/Methods
	public void enterEmail(String email) {
		System.out.println("executing code using page factory concept");
		txt_Email.clear();
		txt_Email.sendKeys(email);
	}

	public void enterPass(String pwd) {
		txt_Pass.clear();
		txt_Pass.sendKeys(pwd);
	}

	public void clickCheckBox() {
		chk_RememberMe.click();
	}

	public void clickLoginButton() {
		btn_Login.click();
	}

	public void clickLogout() {
		btn_Logout.click();
	}

	public void clickLogoutUsingDelay() throws Exception {    // these two methods are created for refferenec
		clickOnWebElement(btn_Logout);
	}

	public void clickOnWebElement(WebElement ele) throws Exception {
		ele.click();
		Thread.sleep(2000);
	}

	public void verifyAppTitle(String expValue) {
		Assert.assertEquals(driver.getTitle(), expValue);
	}
	

}

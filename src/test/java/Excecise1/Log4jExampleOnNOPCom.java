package Excecise1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseTestForLog4JExample;

public class Log4jExampleOnNOPCom extends BaseTestForLog4JExample {

	@Test(priority = 1, description = "Login with valid user crednetails")
	public void verifyLogin() {
		log.info("clear userName field.");
		driver.findElement(By.id("Email")).clear();
		log.info("enter value into userName field: " + conf.getAdminUser());
		driver.findElement(By.id("Email")).sendKeys(conf.getAdminUser());
		log.info("clear password field.");
		driver.findElement(By.id("Password")).clear();
		log.info("enter value into password field: " + conf.getAdminPass());
		driver.findElement(By.id("Password")).sendKeys(conf.getAdminPass());

		log.info("click on checkbox RememberMe.");
		driver.findElement(By.id("RememberMe")).click();

		log.info("click on login Button");
		driver.findElement(By.tagName("button")).click();

	}

	@Test(priority = 2)
	public void verifyAppTitle() {
		log.info("Validation of Application title");
		log.info("Actual Title: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Dashboard"));
	}

	@Test(priority = 3)
	public void verifyLogout() {
		log.info("Click on Logout button");
		driver.findElement(By.linkText("Logout")).click();
	}

}

package ExtentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseTest.BaseTestForExtentReport;

public class ExtentReportExampleOnGoogle extends BaseTestForExtentReport {
	
	public WebDriver driver;   // we have make it public becoz we have those in basetest which is from another package
	public ExtentReports extent;
	public ExtentTest logger;
	
	@Test
	public void verifyAppTitle() {
		
		logger = extent.createTest("To verify application Google title");
		logger = extent.createTest("Enter userName");   // just for reference we are creating to show how it will track in extent report
		logger = extent.createTest("Enter Password");
		logger = extent.createTest("Click on login button");
		
		Assert.assertEquals(driver.getTitle(),"Google");
		
	}

	
	
	@Test
	public void verifyAppLogo() {
		
		logger = extent.createTest("To verify application logo");
		Boolean img_present = driver.findElement(By.cssSelector("img[alt='Google']")).isDisplayed();
		
		
		logger.createNode("Image is present");
		Assert.assertTrue(img_present);
		
		
		
		
		logger.createNode("Image is not present");
		Assert.assertFalse(img_present);
		
		
	}
	
}



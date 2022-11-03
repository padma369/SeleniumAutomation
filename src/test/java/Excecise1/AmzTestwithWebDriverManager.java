package Excecise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.ConfigRead;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmzTestwithWebDriverManager {

	WebDriver driver;

	@Parameters("ibm_browser")
	@Test

	public void verifySearchFeature(String browser) throws Exception {
		// create an object
		ConfigRead conf = new ConfigRead();
		// String browser = conf.getBrowser(); //we are not calling get browser method
		// from config read class. a swe are passing the browser name from testNg xml
		// file
		String url = conf.getAmazonApp();
		System.out.println("Get value from testNG xml file and Browser Execution : " + browser);
		System.out.println("App URL : " + url);

		if (browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\Act\\Downloads\\chromedriver_win32_106\\chromedriver.exe");
			driver = WebDriverManager.chromedriver().create();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			// System.setProperty("webdriver.edge.driver",
			// "C:\\Users\\Act\\Downloads\\edgedriver_win64_106\\msedgedriver.exe");
			driver = WebDriverManager.edgedriver().create();
		}

		else {
			// System.setProperty("webdriver.chrome.driver","C:\\Users\\Act\\Downloads\\chromedriver_win32_106\\chromedriver.exe");
			driver = WebDriverManager.firefoxdriver().create();
		}

		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get(url);
		String searchItem = "iphone 14";
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys(searchItem);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);

		// validation step
		String appTitle = driver.getTitle();
		System.out.println("Application title after search item: " + appTitle);
		Assert.assertEquals("Amazon.in : iphone 14", appTitle);
		Assert.assertEquals("Amazon.in : " + searchItem, appTitle);
		System.out.println(appTitle.contains(searchItem));
		Assert.assertTrue(appTitle.contains(searchItem));

		Thread.sleep(5000);
		driver.close();

	}

}

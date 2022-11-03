package Excecise1;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public WebDriver driver;

	@BeforeTest
	public void launchApp() {
		System.out.println("launching .....");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterTest
	public void closingApp() throws Exception {
		Thread.sleep(7000);
		driver.close();
		System.out.println("closing....");
	}

	@Test
	public void draganddrop() throws Exception {
		WebElement dragdropFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo')]"));
		driver.switchTo().frame(dragdropFrame);
		// Method1
		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
		WebElement trash = driver.findElement(By.cssSelector("div#trash"));
		Actions act = new Actions(driver);
		act.dragAndDrop(img3, trash).perform(); // this is one type for image 3

		// Method2
		// A convenience method that performs click-and-hold at the location of the
		// source element,
		// moves to the location of the target element, then releases the mouse.
		// act.clickAndHold(img4).moveToElement(trash).release().perform();

		act.clickAndHold(img4).moveToElement(trash).release().build().perform(); // this is another type for img 4

		
		
		
		// Mouse hover actions in Amazon site.
		Thread.sleep(3000);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement AmzSigninBtn = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement BabywhishlistOpt = driver.findElement(By.xpath("//span[contains(text(),'Baby Wishlist')]"));
		
	//	act.moveToElement(AmzSigninBtn).moveToElement(BabywhishlistOpt).click().perform();

		act.moveToElement(AmzSigninBtn).moveToElement(BabywhishlistOpt).perform();  // we can use build.perform as well
		BabywhishlistOpt.click();
		Thread.sleep(2000);

		WebElement Babywhishlistheader = driver.findElement(By.xpath("//img[@alt='Amazon: Baby Wish List']//parent::div[@class='br-cls-div-homepage-logo']"));
	//	String Header = Babywhishlistheader.getText();   // we wont get any text here bcoz in html page, we dont have any text for this header.		
	//	System.out.println("header is: " +Header);  // it will return blank value becox we dont have any text
	//	Assert.assertEquals("baby whishlist", Header);
		
		
		//Validation:
		System.out.println("title is: " +driver.getTitle());		
		Assert.assertTrue(driver.getTitle(). contains("Baby Wish"));
		
		
		
		
		

	}

}

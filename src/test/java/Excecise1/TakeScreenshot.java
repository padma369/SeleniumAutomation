package Excecise1;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TakeScreenshot {
	
WebDriver driver;

  @BeforeTest
    public void launchApp() {
    driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

    }

    

    @AfterTest

    public void closeApp() throws Exception {
     Thread.sleep(5000);
        driver.close();  

    }

    

    @Test

    public void SearchTest() throws Exception {
 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14" + Keys.ENTER);

//      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14" );
//      driver.findElement(By.id("nav-search-submit-button")).click();

      Thread.sleep(5000);
   //capture a screenshot
 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);          //captured a screenshot
 File target = new File("./test-output/screenshot/AmazonTest.png");
FileUtils.copyFile(screenshotFile, target);

    }



}



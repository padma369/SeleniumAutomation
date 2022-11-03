package Excecise1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	 @Test

	    public void verifyLoginLogoutTest() throws Exception {

	       WebDriver driver; 
	     driver=    WebDriverManager.chromedriver().create();
  driver.manage().window().maximize();

	        

	        //Implicit wait  -------- any elememt
 driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");       
// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   //if the element is not lpaded in 30 sec, the test will be failed. so we can use exeplicit wait.
 //using this implicit wait, we can eliminate the synchronization issues aswell


	        //Explicit Wait
	        //wait for specific condition
  WebDriverWait wait = new WebDriverWait(driver, 600);       //max time
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#text3")));
  WebElement txt_box = driver.findElement(By.cssSelector("#text3"));                  
  txt_box.sendKeys("enter value Admin.......");

	        driver.close();
      

	    }
    

	}




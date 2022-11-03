package Excecise1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitwaitforAlerts {
	
	@Test

    public void verifyLoginLogoutTest() throws Exception {

WebDriver driver;
     driver=    WebDriverManager.chromedriver().create(); 
        driver.manage().window().maximize();



        // Implicit wait -------- any elememt
      driver.get("http://only-testing-blog.blogspot.com/2014/01/new-testing.html?");
     //   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   //if the element is not visible to to click  in 10sec, then the test willl be failed. so we can use explivit wait.

  
  // Explicit Wait
  // wait for specific condition
  customDelay(driver, 20);  // explicit wait method calling
 // handle alert
  Alert al = driver.switchTo().alert();
  System.out.println(al.getText());
  al.accept();

        driver.close();
        
 }


	
	

    public void customDelay(WebDriver driver, int timedelay) {
 WebDriverWait wait = new WebDriverWait(driver, timedelay); // max time
 wait.until(ExpectedConditions.alertIsPresent());
 }



    public void customDelayForElement(WebDriver driver, WebElement ele) {  //sample method fpr different elements
 WebDriverWait wait = new WebDriverWait(driver, 10); // max time
 wait.until(ExpectedConditions.visibilityOf(ele));
 }



}



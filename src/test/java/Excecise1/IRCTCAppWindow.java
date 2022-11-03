package Excecise1;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseTest.BaseTestForTestNg;

public class IRCTCAppWindow extends BaseTestForTestNg {
	
	
	@Test

    public void verifyWindow() throws Exception {

        String parentWindow = driver.getWindowHandle(); 
        System.out.println("mainWindow: " + parentWindow);
 //handle model - swicthing not required
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='OK']")).click();
 Thread.sleep(3000);
 //handle windows
 //click on Hotel link/Tab

        Thread.sleep(4000);
        driver.findElement(By.linkText("HOTELS")).click();
  Set<String>  allwindow = driver.getWindowHandles();     //multiple windows
  System.out.println("windows count: " + allwindow.size());
  String mainWindow = (String)allwindow.toArray()[0];
  String hotelWindow = (String)allwindow.toArray()[1];
  System.out.println("mainWindow: "+ mainWindow);
  System.out.println("hotelWindow: "+ hotelWindow);

        

        System.out.println("===================================================================");

        

        //Switch To Hotel Window

        Thread.sleep(4000);
        driver.switchTo().window(hotelWindow);
        driver.findElement(By.linkText("Login")).click();
       
        

        //Switch To Main Window

        Thread.sleep(4000);
        driver.switchTo().window(mainWindow);
        driver.findElement(By.linkText("CONTACT US")).click();

                

        //Switch To Hotel Window

        Thread.sleep(4000);
        driver.switchTo().window(hotelWindow);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(4000);
        
        
    }
       
   
              

    }

   



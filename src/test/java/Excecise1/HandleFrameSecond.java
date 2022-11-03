package Excecise1;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.Test;

import BaseTest.BaseTestForTestNg;



public class HandleFrameSecond extends BaseTestForTestNg {
  
	@Test

    public void verifyFrame() throws Exception {
 Thread.sleep(3000);
  //Frame - handling
  driver.switchTo().frame(1);


        //validation step
   driver.findElement(By.xpath("//a[text()='Actions' and @target=\"classFrame\"]")).click();
        Thread.sleep(3000);
   System.out.println(driver.getTitle());
  }

}



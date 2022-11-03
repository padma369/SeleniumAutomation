package Excecise1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import BaseTest.BaseTestForLog4JExample;

public class DataDrivenTest extends BaseTestForLog4JExample{
	
	@Test(priority = 1, description = "Login with Invalid user crednetails", dataProvider = "sampleData")

    public void verifyLoginWithInValidUser(String uname, String pwd) throws Exception {
Thread.sleep(2000);
        log.info("clear userName field.");
        driver.findElement(By.id("Email")).clear();
        log.info("enter value into userName field: " + uname);
        driver.findElement(By.id("Email")).sendKeys(uname);
        Thread.sleep(2000);
        log.info("clear password field.");
        driver.findElement(By.id("Password")).clear();
        log.info("enter value into password field: " + pwd);
        driver.findElement(By.id("Password")).sendKeys(pwd);        

        Thread.sleep(2000);
        log.info("click on checkbox RememberMe.");
        driver.findElement(By.id("RememberMe")).click();
        Thread.sleep(2000);
        log.info("click on login Button");
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
        //Validation step for error message
        log.info("Validation of error message for invalid user details");
        Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful"));       

    }

    

    @DataProvider
    public Object[][] sampleData() {
     Object[][] data = { {"prem@yahoomail.com", "demo@123"},{"Rupam@google.com", "demo@123"}, {"shivani@gmail.com","password@123"}};
        return data;
    }


}


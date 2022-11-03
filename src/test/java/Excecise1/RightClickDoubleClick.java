package Excecise1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickDoubleClick {
	
	public WebDriver driver;



    @BeforeTest
    public void launchApp() {
 System.out.println("launching .....");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}



    @AfterTest
    public void closingApp() throws Exception {
Thread.sleep(7000);
driver.close();
System.out.println("closing....");
}



    @Test(priority = -1)
    public void rightClickTest() throws Exception {
 WebElement rightButton = driver.findElement(By.xpath("//span[contains(text(),'right')]"));

        // rightButton.click();
 Actions act = new Actions(driver);
 act.contextClick(rightButton).perform();
 WebElement btnDel = driver.findElement(By.xpath("//span[contains(text(),'Del')]"));
 btnDel.click();
// act.click(btnDel);
// handle alert
 Alert del_alert = driver.switchTo().alert();
System.out.println(del_alert.getText());
Thread.sleep(2000);
del_alert.dismiss();
 }

    

    @Test
    public void doubleClickTest() throws Exception {
  WebElement doubleButton = driver.findElement(By.xpath("//button[contains(text(),'Dou')]"));
 // rightButton.click();
 Actions act = new Actions(driver);
 act.doubleClick(doubleButton).perform();
// handle alert
 Alert del_alert = driver.switchTo().alert();
 System.out.println(del_alert.getText());
Thread.sleep(2000);
 del_alert.dismiss();
}



}





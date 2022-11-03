package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utility.ConfigRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;


public class BaseTestPOM {
	
	public WebDriver driver;
    public ConfigRead conf;
    public Logger log;
    public LoginPage lp;
    Actions act;
    

    @BeforeTest
    public void launchApp() throws Exception {
 //log file
 log = Logger.getLogger("NOP Comm Login Module");
 PropertyConfigurator.configure(".\\testData\\log4j.properties");
 
 //Create an Object Config
 conf = new ConfigRead();
  log.info("launching chrome browser.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        log.info("launching application: " + conf.getNOPComm());
        driver.get(conf.getNOPComm());
        
        
//create an Object of Action clas
  act = new Actions(driver);   // this object we have created for reference. in future if we want to mousehover this actions may use.
        lp = new LoginPage(driver);  // this object for driver
        //lp = LoginPage(driver);
        
    }



    @AfterTest
    public void closingApp() throws Exception {
 Thread.sleep(5000);
 driver.close();
 log.info("chrome browser closed.");
    }



}





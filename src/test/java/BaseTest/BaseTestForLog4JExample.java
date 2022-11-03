package BaseTest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utility.ConfigRead;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTestForLog4JExample {
	
	public WebDriver driver;
    public ConfigRead conf;
    public Logger log;

    

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
    }



    @AfterTest
    public void closingApp() throws Exception {
 Thread.sleep(5000);
 driver.close();
 log.info("chrome browser closed.");
    }



}





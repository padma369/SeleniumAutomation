package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTestForTestNg {
	
	 public WebDriver driver;

	    

	    @BeforeTest

	    public void launchApp() {



	        System.out.println("launching .....");
	     driver =   WebDriverManager.chromedriver().create();
  driver.manage().window().maximize();
	      //  driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/support/ui/Select.html");
   driver.get("https://www.irctc.co.in/nget/train-search");



	    }



	    @AfterTest

	    public void closingApp() throws Exception {
  Thread.sleep(5000);
	        driver.close();
  System.out.println("closing....");

	    }

	    



	}


	
	



package BaseTest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestForExtentReport {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentHtmlReporter htmlReport;

	ExtentTest logger;

	@BeforeTest
	public void startReport() throws Exception{

		String date_number = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		System.out.println(date_number);
		

		htmlReport = new ExtentHtmlReporter("./test-output/IBM_Automation_Extent_" + date_number + "_.html");

		// create an object
		extent = new ExtentReports();

		// customize Report
		extent.attachReporter(htmlReport);
		
		extent.setSystemInfo("HostName", "IBM_Host");
		extent.setSystemInfo("CloudProvider", "On-Premises");
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("UserName", "Rajesh Singh");
		extent.setSystemInfo("ExecutedBy", "Bhavana");

		htmlReport.config().setDocumentTitle("IBM- Functional Automation - GUI and API report");

		htmlReport.config().setReportName("Regression Report - GUI and API");

		htmlReport.config().setTheme(Theme.DARK);
		
		

	}

	@BeforeMethod
	public void launchapp() {

	driver= 	WebDriverManager.chromedriver().create();
		

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void closeApp() throws Exception {
		
		Thread.sleep(2000);
		driver.close();
		
	}

	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			System.out.println("test case failed.......");
			logger.log(Status.FAIL, "Test case name: " + result.getName());
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test case Failed.....", ExtentColor.AMBER));

			
			//capture screenshot
			
			
			
			
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {

			System.out.println("test case pass.......");

			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "- Test case Pass", ExtentColor.GREEN));

		}

		else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("test case skipp.......");
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "- Test case Skipped", ExtentColor.ORANGE));

		}

	}

	
	@AfterTest
	public void closeReport() {
		
		extent.flush();

}
	
}

package Pages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Common.BaseClass;

public class TC_ProductCancellation extends BaseClass{
	
	public static  int priority=0; 


	@Test(priority=1)
	public void main()
	{
				LaunchUrl();
				Login objLogin = new Login();
				objLogin.LoginToFlipkart(getKeyValue("userName"),getKeyValue("password"));
			  
	}
	@Test(priority=2)
	public void productcancellation()
	{
		productcancellation objproductcancellation = new productcancellation();
		objproductcancellation.cancelproduct();
		
	}
	@BeforeTest
	  public void beforeTest() {
			
			InitializeDriver();	
			extent =  new ExtentReports();
		    htmlReporter = new ExtentHtmlReporter("ExtentCancelReport.html");
		    extent.attachReporter(htmlReporter);
			ProductCancellTestReporter = extent.createTest("Product Cancellation Test Report", "Flipkart Product Cancellation");
			SetTestingAttributes();
	  }

	  
		@AfterTest
	  public void afterTest() {
			extent.flush();
			driver.quit();	
	  }
}

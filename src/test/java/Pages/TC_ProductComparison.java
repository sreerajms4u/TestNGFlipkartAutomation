package Pages;

import org.testng.annotations.Test;

import Common.BaseClass;
import Common.UtilityClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TC_ProductComparison extends BaseClass{
	
  @Test
  public void Main() {
		
		LaunchUrl();
		Login objLogin = new Login();
		objLogin.LoginToFlipkart(getKeyValue("userName"),getKeyValue("password"));
  }
  
	@BeforeTest
  public void beforeTest() {
		
		InitializeDriver();	
		ProductComparisonTestReporter = extent.createTest("Product Comparison Test Report", "Flipkart Product Comparison");
		SetTestingAttributes();
  }

  
	@AfterTest
  public void afterTest() {
		//driver.quit();	
  }

}

package Pages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Common.BaseClass;

public class TC_ProductPurchaseClass extends BaseClass{
	
	public static final int priority = 0;


	@Test(priority=1)
	  public void Main() {
		
			ProductPurchaseTestReporter.info("Loading Browser...");
			LaunchUrl();
			ProductPurchaseTestReporter.info("Loaded URL");
			Login objLogin = new Login();
			objLogin.LoginToFlipkart(getKeyValue("userName"),getKeyValue("password"));
		  }
	  @Test(priority=2)
	  public void searchproduct()
	  {
		  ProductSearch objProductSearch = new ProductSearch();
			try {
				objProductSearch.SearchProductItem(getKeyValue("sItemName"));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  
	  @Test(priority=3)
	  
	  public void productpurchase()
	  {
		  PurchaseProduct objPurchaseProduct = new PurchaseProduct();
		  try {
			objPurchaseProduct.PurchaseProductItem();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ProductPurchaseTestReporter.fail("Product Purchase failed");
		}
	  }
	  
		@BeforeTest
	  public void beforeTest() {
			
			InitializeDriver();	
			extent =  new ExtentReports();
		    htmlReporter = new ExtentHtmlReporter("ExtentPurchaseReport.html");
		    extent.attachReporter(htmlReporter);
			ProductPurchaseTestReporter = extent.createTest("Product Purchase Test Report", "Flipkart Product Purchase");
			SetTestingAttributes();
	  }

	  
		@AfterTest
	  public void afterTest() {
			driver.close();
			driver.quit();
			//extent.flush();
			//driver.quit();	
	  }

	}

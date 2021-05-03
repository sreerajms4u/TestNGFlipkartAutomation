package BrowserStack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.ProductSearch;
import Pages.PurchaseProduct;
import Pages.TC_ProductPurchaseClass;

public class ProductPurchaseBrowserStack extends TC_ProductPurchaseClass {

	@Test(priority=1)
	  public void Main() {
		
			
			LaunchUrl();			
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
			
		}
	  }
	  
		@BeforeTest
	  public void beforeTest() {
			
			InitializeDriver();				
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

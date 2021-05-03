package Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Common.BaseClass;

public class PurchaseProduct extends BaseClass {
	public void PurchaseProductItem() throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Buynow)).click();	
		wait.until(ExpectedConditions.elementToBeClickable(DeliverHere)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ToPayment)).click();
		wait.until(ExpectedConditions.elementToBeClickable(COD)).click();
		ProductPurchaseTestReporter.fail("Confirm Order failed");
		extent.flush();
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmOrder)).click();
		
		Reporter.log("TC to test Flipkart Product purchase functioanlity ended", true);
		
	}

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import Common.BaseClass;

public class productcancellation extends BaseClass {
	public void cancelproduct()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		ProductCancellTestReporter.info("Product cancellation initialized");
		
		driver.get("https://www.flipkart.com/account/orders?link=home_orders");
		ProductCancellTestReporter.pass("Order page loaded");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='container']/div/div[3]/div[2]/div/div[3]/div/div[1]/div"))).click(); 
		
		wait.until(ExpectedConditions.elementToBeClickable(CancelItem)).click();
		Select drpCategory= new Select(driver.findElement(SearchReasonforCancellation));
		drpCategory.selectByVisibleText("I have changed my mind");
		wait.until(ExpectedConditions.elementToBeClickable(CancelOrder)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ContinueCancel)).click();
		wait.until(ExpectedConditions.elementToBeClickable(RefundStatus)).click();
		ProductCancellTestReporter.pass("Product cancelled");
		Reporter.log("TC to test Flipkart Product cancellation ended", true);
	}

}

package Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import Common.BaseClass;

public class ProductSearch extends BaseClass {
	public void SearchProductItem(String item ) throws InterruptedException
	{		
		Reporter.log("TC to test Flipkart Search functioanlity started", true);
		ProductPurchaseTestReporter.log(Status.INFO, "Starting Product search");
		
		
		driver.findElement(searchBoxBy).sendKeys(sItemKey);
		WebElement searchResult = getElement(By.xpath(sSearchResult)); 
		searchResult.click(); 
		ProductPurchaseTestReporter.pass("Search Product success");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String sBookName = "(//a[contains(.,'Selenium')])[last()]"; 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sBookName))).click(); 
		//driver.findElement(By.xpath(sItemName)).click();
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		ProductPurchaseTestReporter.pass(" Product listing success");
		ProductPurchaseTestReporter.info("This step shows usage of info(details)");
				
		Reporter.log("TC to test Flipkart Search functioanlity ended", true);
		
		
	}

}

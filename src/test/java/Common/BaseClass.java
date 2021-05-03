package Common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.internal.collections.Pair;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;


public class BaseClass extends UtilityClass {
	public static WebDriver driver;
	public static final String USERNAME = "sivaranjanis_FzDHKv";
	public static final String AUTOMATE_KEY = "rzxEzZvR2GqTUByiAyYy";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static  ExtentReport report;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest ProductPurchaseTestReporter;
	public static ExtentTest ProductCancellTestReporter;
	public static ExtentTest ProductComparisonTestReporter;	
	
	//Login Controls
	public static By usernameBy = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input");
	public static By passwordBy = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input");
	public static By signInSubmitBy = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button");
	
	//Product Search Controls
	public static By searchBoxBy = By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");	
	public static String sItemKey = "selenium";
	public static String sSearchResult = "//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/button";
	public static String sItemName = "//a[contains(.,'Selenium')])[1]";
	
	//Purchase Product Controls
	public static By Buynow = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button");
	public static By DeliverHere = By.xpath("//*[@id='CNTCT1EDE06F6D5F24944AA2338C38']/button");
	public static By ToPayment = By.xpath("//*[@id='to-payment']/button");
	public static By COD = By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[5]/div[1]");
	public static By ConfirmOrder = By.xpath("//*[@id='container']/div/div[2]/div/div[1]/div[4]/div/div/div[2]/div/label[5]/div[2]/div/div/div[3]/form/button/span");
	
	//Compare Product Controls
	
	//Cancel Product Controls
	public static By OrderHover = By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div");
	                                        
	
	public static By Order = By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li[4]/a/div");
	
	public static By CancelItem = By.xpath("//*[@id='container']/div/div[3]/div[2]/div/div[4]/div/div[1]/div[3]/div[2]/div[1]/span/span");
	public static By SearchReasonforCancellation = By.name("reasonList");
	public static By CancelOrder = By.xpath("//*[@id='container']/div/div[4]/div[1]/div[1]/div/div/div[2]/div/div[2]/label[2]/div[1]");
	
	public static By ContinueCancel = By.xpath("//*[@id='container']/div/div[4]/div[1]/div[1]/div/div/div[2]/div/div[3]/button");
	public static By RefundStatus = By.xpath("//*[@id='container']/div/div[4]/div[1]/div[2]/div/div/div/div/div[2]/div/button");
	
	
	public static List<Pair<String, String>> TestingAttributes = new ArrayList<Pair<String, String> >();
	
	
	public static void InitializeDriver() {
		
		
//			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
//			driver= new ChromeDriver();
//			driver.manage().window().maximize();
//		    driver.manage().deleteAllCookies();
		String methodName = "BrowserStack Test - Chrome";
		
		DesiredCapabilities caps = new DesiredCapabilities();
        
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser_version", "85.0");
		caps.setCapability("name", methodName);
		

		caps.setCapability("browser", "Chrome");
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		    extent =  new ExtentReports();
		    htmlReporter = new ExtentHtmlReporter("extent.html");
		    extent.attachReporter(htmlReporter);
		
		}
	public static void LaunchUrl()
	{
		driver.get("https://www.flipkart.com");
		//driver.manage().deleteAllCookies();
	}
	public static void SetTestingAttributes()
	{
		ExcelHandler objExcelFile = new ExcelHandler();
		try {
			TestingAttributes = objExcelFile.readExcel("ExternalSource.xls","FlipkartDetails");
		} catch (IOException e) {
			//logger.info(e.getMessage());
		}
	}
public String getKeyValue(String key){
		
		String value = "";
		for (org.testng.internal.collections.Pair<String, String> pair : TestingAttributes) {
			
				String id = pair.first().toString().trim();
				if(id.equals(key) ){
				value =  pair.second();
				break;
		}
		
		}
	return value;
	
}
public static WebElement getElement(final By locator) { 
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS) 
			.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class); 

	WebElement element = wait.until(new Function<WebDriver, WebElement>() { 

		public WebElement apply(WebDriver arg0) { 
			return arg0.findElement(locator); 
		} 

	}); 

	return element; 
} 

	}
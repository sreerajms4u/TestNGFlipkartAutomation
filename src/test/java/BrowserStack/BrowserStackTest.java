package BrowserStack;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;


public class BrowserStackTest {
	
	
	WebDriver driver;
	public static final String USERNAME = "sivaranjanis_FzDHKv";
	public static final String AUTOMATE_KEY = "rzxEzZvR2GqTUByiAyYy";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	@Parameters({"browser", "browser_version", "os", "os_version"})
	
	@BeforeMethod
	public void setUp(String browserName, String browser_version, String os, String os_version,  Method name) {

		System.out.println("browser name is : " + browserName);
		String methodName = name.getName();
		
		DesiredCapabilities caps = new DesiredCapabilities();
        
		caps.setCapability("os", os);
		caps.setCapability("os_version", os_version);
		caps.setCapability("browser_version", browser_version);
		caps.setCapability("name", methodName);
		

		caps.setCapability("browser", "Chrome");
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}

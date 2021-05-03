package Pages;

import Common.BaseClass;

public class Login extends BaseClass {

	public void LoginToFlipkart(String userName, String password)
	{
		driver.findElement(usernameBy).sendKeys(userName);
	    driver.findElement(passwordBy).sendKeys(password);
	    driver.findElement(signInSubmitBy).click();
	}
}

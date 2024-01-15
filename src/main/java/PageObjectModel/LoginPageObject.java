package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
public WebDriver driver;   //WebDriver Declare Globally
	
	private By username = By.xpath("//input[@name='email']");
	
	private By password = By.xpath("//input[@name='password']");
	
	private By submit = By.xpath("//input[@type='submit']");
	
	//driver2 took the scope of driver from register test case
	public LoginPageObject(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement enterusername() 
	{
		return driver.findElement(username);
	}
	
	public WebElement enterpassword() 
	{
		return driver.findElement(password);
	}
	
	public WebElement entersubmit() 
	{
		return driver.findElement(submit);
	}
}

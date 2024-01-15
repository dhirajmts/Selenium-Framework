package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterationPageObject {
	
	public WebDriver driver;   //WebDriver Declare Globally
	
	private By firstname = By.xpath("//input[@name='firstname']");
	
	private By laststname = By.xpath("//input[@name='lastname']");
	
	private By email = By.xpath("//input[@name='email']");
	
	private By telephone = By.xpath("//input[@name='telephone']");
	
	private By password = By.xpath("//input[@name='password']");
	
	private By passwordconfirm = By.xpath("//input[@name='confirm']");
	
	private By subscribe = By.xpath("(//input[@name='newsletter'])[2]");
	
	private By privacyPolicy = By.xpath("//input[@name='agree']");
	
	private By continueButton = By.xpath("//input[@value='Continue']");
	
	private By firstNameErrorMsg = By.xpath("//div[@class='text-danger'][1]");
	
	private By lastNameErrorMsg = By.xpath("(//div[@class='text-danger'])[2]");
	
	//driver2 took the scope of driver from register test case
	public RegisterationPageObject(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement enterfirstname() 
	{
		return driver.findElement(firstname);
	}
	
	public WebElement enterlastname() 
	{
		return driver.findElement(laststname);
	}
	
	public WebElement enteremail() 
	{
		return driver.findElement(email);
	}
	
	public WebElement entertelephone() 
	{
		return driver.findElement(telephone);
	}
	
	public WebElement entertpassword() 
	{
		return driver.findElement(password);
	}
	
	public WebElement enterpasswordconfirm() 
	{
		return driver.findElement(passwordconfirm);
	}
	
	public WebElement ClickOnsubscribe() 
	{
		return driver.findElement(subscribe);
	}
	
	public WebElement ClickOnprivacyPolicy() 
	{
		return driver.findElement(privacyPolicy);
	}
	
	public WebElement ClickOncontinueButton()
	{
		return driver.findElement(continueButton);
	}
	
	public WebElement CaptureFirstNameErrorMsg()
	{
		return driver.findElement(firstNameErrorMsg);
	}
	
	public WebElement CaptureLastNameErrorMsg()
	{
		return driver.findElement(lastNameErrorMsg);
	}
	
}

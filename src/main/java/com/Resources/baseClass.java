package com.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class baseClass {
	
	public WebDriver driver;
	public Properties prop;
	
	public void initializeDriver() throws IOException {
		//read the data from properties file
		//FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Selenium_Framework\\src\\main\\java\\com\\Resources\\data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\\\src\\\\main\\\\java\\\\com\\\\Resources\\\\data.properties");
		
		//Access the properties file
		prop = new Properties();
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("EdgeDriver")) {
			
			driver = new EdgeDriver();
		}
	}
	
	@BeforeClass
	public void launchbrowser() throws IOException {
		
		initializeDriver();
		
		driver.get(prop.getProperty("url"));
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	public String generateRandomEmail()
	{
		return System.currentTimeMillis()+"@gmail.com";
	}

}

package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Resources.baseClass;
import com.Resources.constants;

import PageObjectModel.HomePageObject;
import PageObjectModel.LoginPageObject;

public class LoginTestCases extends baseClass{
	@Test
	public void verifyRegistration() throws IOException, InterruptedException {
		
		Thread.sleep(3000);
		
		HomePageObject hpo = new HomePageObject(driver);
		hpo.clickonMyAccount().click();
		hpo.clickonLogin().click();
		//initializeDriver();
		
		//This driver has scope -->Because it coming from baseClass
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		LoginPageObject lpo = new LoginPageObject(driver);
		lpo.enterusername().sendKeys(RegisterTestCases.randomEmail);
		System.out.println("LogIn Email : "+RegisterTestCases.randomEmail);
		
		lpo.enterpassword().sendKeys(constants.passwordconfirm);
		System.out.println("LogIn Password : "+constants.passwordconfirm);
		
		lpo.entersubmit().click();
	}
}

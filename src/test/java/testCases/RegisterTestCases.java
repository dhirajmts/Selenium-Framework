package testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Resources.baseClass;
import com.Resources.commonMethods;
import com.Resources.constants;

import PageObjectModel.HomePageObject;
import PageObjectModel.RegisterationPageObject;

public class RegisterTestCases extends baseClass {
	
	public static String randomEmail = "";    //step1
	
	@Test
	public void verifyRegistrationWithBlankData() throws IOException, InterruptedException {
		
		//Thread.sleep(3000);
		
		HomePageObject hpo = new HomePageObject(driver);
		
		commonMethods.putExplicitWait(driver, 10, hpo.clickonMyAccount());
		
		hpo.clickonMyAccount().click();
		hpo.clickonRegister().click();
		//initializeDriver();
		
		//This driver has scope -->Because it coming from baseClass
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		RegisterationPageObject rpo = new RegisterationPageObject(driver);
		
		rpo.enterfirstname().clear();
		
		rpo.enterfirstname().sendKeys("");
		rpo.enterlastname().clear();
		rpo.enterlastname().sendKeys("");
		
		rpo.enteremail().clear();
		rpo.enteremail().sendKeys("");
		
		rpo.entertelephone().sendKeys("");
		rpo.entertpassword().sendKeys("");
		rpo.enterpasswordconfirm().sendKeys("");
		rpo.ClickOnsubscribe().click();
		rpo.ClickOnprivacyPolicy().click();
		rpo.ClickOncontinueButton().click();
		
//		SoftAssert sa = new SoftAssert();
//	  //String firstNameErrorMsg = "First Name must be between 1 and 32 characters!";
//		String firstNameErrorMsg = constants.firstNameErrorMsg;
//	  //String lastNameErrorMsg = "Last Name must be between 1 and 32 characters!";
//		String lastNameErrorMsg = constants.lastNameErrorMsg;
//		sa.assertAll();
		
		commonMethods.handleeAssertions(rpo.CaptureFirstNameErrorMsg().getText(), constants.firstNameErrorMsg);
		
		commonMethods.handleeAssertions(rpo.CaptureLastNameErrorMsg().getText(), constants.lastNameErrorMsg);
	}
	
//	public String generateRandomEmail()
//	{
//		return System.currentTimeMillis()+"@gmail.com";
//	}
	
	@Test (dependsOnMethods = "verifyRegistrationWithBlankData")
	public void verifyRegistrationWithValidData() throws IOException, InterruptedException {
		
		//Thread.sleep(3000);
		
		randomEmail = generateRandomEmail();     //step2
		
		RegisterationPageObject rpo = new RegisterationPageObject(driver);
		
		commonMethods.putExplicitWait(driver, 10, rpo.enterfirstname());
		
	  //rpo.enterfirstname().sendKeys("test");
		rpo.enterfirstname().sendKeys(constants.firstname);
	  //rpo.enterlastname().sendKeys("test");
		rpo.enterlastname().sendKeys(constants.laststname);
      //rpo.enteremail().sendKeys("test@gmail.com");
		rpo.enteremail().sendKeys(randomEmail);
		
		System.out.println("Random Email : "+randomEmail);
		
	  //rpo.entertelephone().sendKeys("1234567789");
		rpo.entertelephone().sendKeys(constants.telephone);
      //rpo.entertpassword().sendKeys("0707");
		rpo.entertpassword().sendKeys(constants.password);
	  //rpo.enterpasswordconfirm().sendKeys("0707");
		rpo.enterpasswordconfirm().sendKeys(constants.passwordconfirm);
		
		System.out.println("Confirm Password : "+constants.passwordconfirm);
		
		rpo.ClickOnsubscribe().click();
      //rpo.ClickOnprivacyPolicy().click();
		rpo.ClickOncontinueButton().click();
		
//		SoftAssert sa = new SoftAssert();
//	  //String successURL = "https://naveenautomationlabs.com/opencart/index.php?route=account/success";
//		String successURL = constants.successURL;
//		sa.assertEquals(driver.getCurrentUrl(), successURL);
//		sa.assertAll();
		
		commonMethods.handleeAssertions(driver.getCurrentUrl(), constants.successURL);
	}
	
}

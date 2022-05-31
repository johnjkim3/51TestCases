package johnTestCases;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import john.in.automationTesting.pages.HomePage;
import john.in.automationTesting.pages.MyAccountPage;
import john.in.automationTesting.pages.SuccessfulLoginPage;
import johnUtilities.BaseClass;

public class TestMyAccountRegistration {
	
	HomePage hP = new HomePage();
	MyAccountPage mAP = new MyAccountPage();
	SuccessfulLoginPage sLP = new SuccessfulLoginPage();
	
	WebDriverWait wait;

	
	@BeforeTest
	  public void setUp() {
		  
		  BaseClass.getDriver();
		  wait = new WebDriverWait(BaseClass.driver,20);
	  }
	
	@Test (enabled = false)
  	public void test1 () {
		
		hP.MyAccountButton.click();
		mAP.registrationEmail.click();
		mAP.registrationEmail.sendKeys(BaseClass.getProperties("validRegistrationEmail"));
		mAP.registrationPassword.click();
		mAP.registrationPassword.sendKeys(BaseClass.getProperties("validRegistrationPassword"));
		mAP.registrationPassword.sendKeys(Keys.ARROW_LEFT);
		mAP.registrationPassword.sendKeys(Keys.ARROW_RIGHT);
		mAP.registrationButton.click();
		Assert.assertTrue(sLP.logOutButton.isDisplayed());
	}	
	
	@Test (enabled = true)
  	public void test2 () {
		
		hP.MyAccountButton.click();
		mAP.registrationEmail.click();
		mAP.registrationEmail.sendKeys(BaseClass.getProperties("invalidRegistrationEmail"));
		mAP.registrationPassword.click();
		mAP.registrationPassword.sendKeys(BaseClass.getProperties("validRegistrationPassword"));
		mAP.registrationPassword.sendKeys(Keys.ARROW_LEFT);
		mAP.registrationPassword.sendKeys(Keys.ARROW_RIGHT);
		mAP.registrationButton.click();
		mAP.verifyInvalidEmailError(mAP.errorMessage.getText());
	}	
}

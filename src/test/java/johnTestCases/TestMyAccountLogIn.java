package johnTestCases;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import john.in.automationTesting.pages.HomePage;
import john.in.automationTesting.pages.MyAccountPage;
import john.in.automationTesting.pages.SuccessfulLoginPage;
import johnUtilities.BaseClass;

public class TestMyAccountLogIn {
	
	HomePage hP = new HomePage();
	MyAccountPage mAP = new MyAccountPage();
	SuccessfulLoginPage sLP = new SuccessfulLoginPage();
	
	@BeforeTest
	  public void setUp() {
		  
		  BaseClass.getDriver();
	  }
	
	@Test (enabled = false)
  	public void test1 () {
		
		hP.MyAccountButton.click();
		mAP.username.click();
		mAP.username.sendKeys(BaseClass.getProperties("validUsername"));
		mAP.password.click();
		mAP.password.sendKeys(BaseClass.getProperties("validPassword"));
		mAP.logInButton.click();
		Assert.assertTrue(sLP.logOutButton.isDisplayed());
	}	
	@Test (enabled = false)
	public void test2 () {
	
		hP.MyAccountButton.click();
		mAP.username.click();
		mAP.username.sendKeys(BaseClass.getProperties("invalidUsername"));
		mAP.password.click();
		mAP.password.sendKeys(BaseClass.getProperties("invalidPassword"));
		mAP.logInButton.click();
		mAP.verifyInvalidUsernameError(mAP.errorMessage.getText());
	}
		
	@Test (enabled = false)
	public void test3() {
		
		hP.MyAccountButton.click();
		mAP.username.click();
		mAP.username.sendKeys(BaseClass.getProperties("validUsername"));
		mAP.password.click();
		mAP.logInButton.click();
		System.out.println(mAP.errorMessage.getText());
		mAP.verifyPasswordRequiredError(mAP.errorMessage.getText());
	}
  
	@Test (enabled = false)
	public void test4 () {
	
		hP.MyAccountButton.click();
		mAP.password.click();
		mAP.password.sendKeys(BaseClass.getProperties("validPassword"));
		mAP.logInButton.click();
		mAP.verifyUsernameRequiredError(mAP.errorMessage.getText());
	}
	
	@Test (enabled = false)
	public void test5 () {
	
		hP.MyAccountButton.click();
		mAP.logInButton.click();
		mAP.verifyUsernameRequiredError(mAP.errorMessage.getText());
	}
	
	@Test (enabled = false)
	public void test6 () {
	
		hP.MyAccountButton.click();
		mAP.password.click();
		mAP.password.sendKeys(BaseClass.getProperties("validPassword"));
		mAP.verifyPasswordIsMasked();
	}
	
	@Test (enabled = false)
	public void test7 () {
	
		hP.MyAccountButton.click();
		mAP.username.click();
		mAP.username.sendKeys(BaseClass.getProperties("caseChangedUsername"));
		mAP.password.click();
		mAP.password.sendKeys(BaseClass.getProperties("caseChangedPassword"));
		mAP.logInButton.click();
		mAP.verifyWrongPasswordError(mAP.errorMessage.getText(), BaseClass.getProperties("caseChangedUsername"));
	}
	
	@Test
	public void test8 () {
		
		hP.MyAccountButton.click();
		mAP.username.click();
		mAP.username.sendKeys(BaseClass.getProperties("validUsername"));
		mAP.password.click();
		mAP.password.sendKeys(BaseClass.getProperties("validPassword"));
		mAP.logInButton.click();
		sLP.logOutButton.click();
		BaseClass.driver.navigate().back();
		mAP.verifyLogInButtonIsDisplayed();

	}	
	
}

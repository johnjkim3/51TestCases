package john.in.automationTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import johnUtilities.BaseClass;

public class MyAccountPage {
  
	public MyAccountPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(xpath = "//*[@name = 'login']")
	public WebElement logInButton;
	
	@FindBy(xpath = "//div[@id='body']//li[1]")
	public WebElement errorMessage;
	
	@FindBy(xpath = "//*[@id='reg_email']")
	public WebElement registrationEmail;
	
	@FindBy(xpath = "//*[@id='reg_password']")
	public WebElement registrationPassword;
	
	@FindBy(xpath = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/div[@id='page-36']/div[1]/div[1]/div[1]/div[2]/form[1]/p[3]/input[3]")
	public WebElement registrationButton;
	
	
	public void verifyInvalidUsernameError (String message) {
		
		Assert.assertTrue(message.equals("ERROR: Invalid username. Lost your password?"));
	}
	
	public void verifyPasswordRequiredError (String message) {
		
		Assert.assertTrue(message.equals("Error: Password is required."));
	}
	
	public void verifyUsernameRequiredError (String message) {
		
		Assert.assertTrue(message.equals("Error: Username is required."));
	}
	
	public void verifyPasswordIsMasked () {
		
		Assert.assertTrue(password.getAttribute("type").equals("password"));
	}
	
	public void verifyWrongPasswordError (String message, String username) {
		
		Assert.assertTrue(message.equals("ERROR: The password you entered for the username " + username + " is incorrect. Lost your password?"));
	}
	
	public void verifyLogInButtonIsDisplayed() {
		
		Assert.assertTrue(logInButton.isDisplayed());
		
	}
	
	public void verifyInvalidEmailError (String message) {
		
		Assert.assertTrue(message.equals("Error: Please provide a valid email address."));
	}
	
}

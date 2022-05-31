package john.in.automationTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import johnUtilities.BaseClass;

public class SuccessfulLoginPage {
	
	public SuccessfulLoginPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	public WebElement logOutButton;
	
	

}

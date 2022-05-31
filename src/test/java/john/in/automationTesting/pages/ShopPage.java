package john.in.automationTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import johnUtilities.BaseClass;

public class ShopPage {
	
	public ShopPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id='content']/nav/a")
	public WebElement homeButton;
	
	

}

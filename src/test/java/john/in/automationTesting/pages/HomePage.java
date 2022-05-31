package john.in.automationTesting.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import johnUtilities.BaseClass;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@href='http://practice.automationtesting.in/my-account/']")
	public WebElement MyAccountButton;
	
	@FindBy(xpath = "//*[@id='menu-item-40']/a")
	public WebElement shopButton;

	@FindBy(xpath = "//*[@class='n2-ss-slider-3']/div")
	public List<WebElement> sliders;
	
	@FindBy(xpath = "//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
	public List<WebElement> newArrivalItems;
	
	@FindBy(xpath = "//*[@title='Selenium Ruby']")
	public WebElement newArrival1;
	
	@FindBy(xpath = "//*[@title='Thinking in HTML']")
	public WebElement newArrival2;
	
	@FindBy(xpath = "//*[@title='Mastering JavaScript']")
	public WebElement newArrival3;
	
	
	
}

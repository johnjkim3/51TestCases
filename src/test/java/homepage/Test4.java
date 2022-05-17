package homepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 {

WebDriver driver;
	
    @Before
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Test
    public void numberOfNewArrivalItems() {
    	
    	WebElement shopButton = driver.findElement(By.xpath("//*[@id='menu-item-40']/a"));
    	shopButton.click();
    	WebElement homeButton = driver.findElement(By.xpath("//*[@id='content']/nav/a"));
    	homeButton.click();
    	
    	List<WebElement> newArrivalItems = driver.findElements(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
    	
    	//check if the number of the New Arrival items is 3.
    	Assert.assertEquals(3, newArrivalItems.size());
    	
    	//check if the link for the first item works
    	WebElement newArrival1 = driver.findElement(By.xpath("//*[@title='Selenium Ruby']"));
    	newArrival1.click();
    	String newArrival1WindowURL = driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	
    	//check the description tab
    	driver.findElement(By.xpath("//*[@class='description_tab active']"));
    	WebElement newArrival1Description = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/p"));
    	
    	driver.navigate().back();
    	
    	//check if the link for the second item works
    	WebElement newArrival2 = driver.findElement(By.xpath("//*[@title='Thinking in HTML']"));
    	newArrival2.click();
    	String newArrival2WindowURL = driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	
    	//check the description tab
    	driver.findElement(By.xpath("//*[@class='description_tab active']"));
    	WebElement newArrival2Description = driver.findElement(By.xpath("//*[@id='product-163']/div[3]/div/div/div/div/p"));
    	    	
    	// check if the item 2 description is different from the item 1 description; it should be different (i.e. false)
    	Assert.assertNotEquals(newArrival1Description, newArrival2Description);
    	
    	driver.navigate().back();

    	//check if the link for the third item works
    	WebElement newArrival3 = driver.findElement(By.xpath("//*[@title='Mastering JavaScript']"));
    	newArrival3.click();
    	String newArrival3WindowURL = driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//check the description tab
    	driver.findElement(By.xpath("//*[@class='description_tab active']"));
    	WebElement newArrival3Description = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/div/div/div/p"));
    	
    	//check if the item 3 description is not same as item 1 or item 2 description
    	Assert.assertNotEquals(newArrival1Description, newArrival3Description);
    	Assert.assertNotEquals(newArrival2Description, newArrival3Description);
         	
    }
    
    
    @After
    public void tearDown() {
    	driver.close();
    }
	
	
}

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

public class Test2 {

WebDriver driver;
	
    @Before
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    }
    
    @After
    public void tearDown() {
    	driver.close();
    }
}

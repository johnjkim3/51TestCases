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

public class Test1 {
	
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
    public void ThreeSliders() {
    	
    	WebElement shopButton = driver.findElement(By.xpath("//*[@id='menu-item-40']/a"));
    	shopButton.click();
    	WebElement homeButton = driver.findElement(By.xpath("//*[@id='content']/nav/a"));
    	homeButton.click();
    	
    	List<WebElement> sliders = driver.findElements(By.xpath("//*[@class='n2-ss-slider-3']/div"));
    	
    	//check if the number of sliders is 3.
    	Assert.assertEquals(3, sliders.size());
    }
    
    @After
    public void tearDown() {
    	driver.close();
    }

}

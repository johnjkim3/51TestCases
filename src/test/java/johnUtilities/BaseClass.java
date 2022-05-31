package johnUtilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			
			switch (BaseClass.getProperties("browser")) {
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
				
			case "headless":
				// code
				break;
		
				
			}
			
			driver.get(BaseClass.getProperties("url"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		
		return driver;
		
	}
	
	public static void tearDown() {
		
		if (driver !=null) {
			driver.quit();
			driver = null;
		}
	}
	
	
	private static Properties configFile;
	
	static {
		
		try {
		
			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\propertiesFolder\\config.properties";
		
		
			FileInputStream input = new FileInputStream(filePath);
			
			configFile = new Properties();
			configFile.load(input);
			
			input.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static String getProperties(String keyName) {
		return configFile.getProperty(keyName);
	}
	
}

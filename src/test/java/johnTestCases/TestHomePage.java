package johnTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import john.in.automationTesting.pages.HomePage;
import john.in.automationTesting.pages.ShopPage;
import johnUtilities.BaseClass;
import johnUtilities.Constants;

public class TestHomePage {
	
	HomePage hP = new HomePage();
	ShopPage sP = new ShopPage();
	
	WebDriverWait wait;
	Actions actions = new Actions(BaseClass.driver); 

	
	@BeforeMethod
	public void setUp() {
		  
		BaseClass.getDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		
		BaseClass.tearDown();
		
	}
	
	@Test (priority = 1)
  	public void test1() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(Constants.slidersCount, hP.sliders.size());
	}
	
	@Test (priority = 2)
  	public void test2() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(Constants.arrivalItemsCount, hP.newArrivalItems.size());
	}
	
	@Test (priority = 3)
  	public void test3() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
	}
	
	@Test (priority = 4)
  	public void test4() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.findElement(By.xpath("//*[@class='description_tab active']"));
    	WebElement newArrival1Description = BaseClass.driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/p"));
    	BaseClass.driver.navigate().back();
    	
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.findElement(By.xpath("//*[@class='description_tab active']"));
    	WebElement newArrival2Description = BaseClass.driver.findElement(By.xpath("//*[@id='product-163']/div[3]/div/div/div/div/p"));
    	// check if the item 2 description is different from the item 1 description; it should be different (i.e. false)
    	Assert.assertNotEquals(newArrival1Description, newArrival2Description);
    	BaseClass.driver.navigate().back();
    	
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	BaseClass.driver.findElement(By.xpath("//*[@class='description_tab active']"));
    	WebElement newArrival3Description = BaseClass.driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/div/div/div/p"));
    	//check if the item 3 description is not same as item 1 or item 2 description
    	Assert.assertNotEquals(newArrival1Description, newArrival3Description);
    	Assert.assertNotEquals(newArrival2Description, newArrival3Description);
	}
	
	@Test (priority = 5)
  	public void test5() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	//check the first item review tab
    	WebElement reviewTab =  BaseClass.driver.findElement(By.xpath("//a[contains(text(),'Reviews (0)')]"));
    	actions.moveToElement(reviewTab); 
    	reviewTab.click();
      	String  newArrival1Review = BaseClass.driver.findElement(By.xpath("//*[@id='comments']/p")).getText();
      	BaseClass.driver.navigate().back();
    	
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	//check the second item review tab
      	reviewTab =  BaseClass.driver.findElement(By.xpath("//a[contains(text(),'Reviews (0)')]"));
      	actions.moveToElement(reviewTab); 
    	reviewTab.click();
      	String  newArrival2Review = BaseClass.driver.findElement(By.xpath("//*[@id='comments']/p")).getText();
      	// check if the item 2 review is different from the item 1 review; it should be different if there is at least one review.
      	Boolean newArrival1ReviewPresence = false;
      	if (!newArrival1Review.equals("There are no reviews yet.")) {
      		newArrival1ReviewPresence = true;
      	}
      	Boolean newArrival2ReviewPresence = false;
      	if (!newArrival2Review.equals("There are no reviews yet.")) {
      		newArrival1ReviewPresence = true;
      	}
      	if (newArrival1ReviewPresence || newArrival2ReviewPresence) {
        	Assert.assertNotEquals(newArrival1Review, newArrival2Review);
     	}
    	BaseClass.driver.navigate().back();
    	
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	//check the third item review tab
      	reviewTab =  BaseClass.driver.findElement(By.xpath("//a[contains(text(),'Reviews (0)')]"));
      	actions.moveToElement(reviewTab); 
    	reviewTab.click();
      	String  newArrival3Review = BaseClass.driver.findElement(By.xpath("//*[@id='comments']/p")).getText();
      	Boolean newArrival3ReviewPresence = false;
      	if (!newArrival2Review.equals("There are no reviews yet.")) {
      		newArrival1ReviewPresence = true;
      	}
      	//check if the item 3 review is not same as item 1 or item 2 review
      	if (newArrival1ReviewPresence || newArrival2ReviewPresence || newArrival3ReviewPresence) {  	
      		Assert.assertNotEquals(newArrival1Review, newArrival3Review);
      		Assert.assertNotEquals(newArrival2Review, newArrival3Review);
      	}
	}
	
	@Test (priority = 6)
  	public void test6() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	}
	
	@Test (priority = 7)
  	public void test7() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	//enter quantity greater than what's allowed
	  	
	  	String getMax = BaseClass.driver.findElement(By.xpath("//*[@class=\"quantity\"]/input ")).getAttribute("Max"); // help from Leng's code
        int moreThanMax = Integer.valueOf(getMax)+1; // help from Leng's code
	  	
	  	Actions action = new Actions(BaseClass.driver);
	  	
	  	WebElement quantityBox = BaseClass.driver.findElement(By.xpath("//*[@class='quantity']/input"));
	  	action.moveToElement(quantityBox).click().perform();
	  	
	  	action.sendKeys(Integer.toString(moreThanMax));
	  	action.build().perform();
	  	
	  	JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
	  	String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", quantityBox);
        
	  	String expectedValue = "Value must be less than or equal to " + getMax + ".";
	  	String actualValue = validationMessage;
	  	
	  	Assert.assertEquals(actualValue, expectedValue);
	  		  	  		
	}
	
	@Test (priority = 8)
  	public void test8() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	//click on the Item link
	  	amountInCart.click();
	}
	
	@Test (priority = 9)
  	public void test9() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//work-around - The coupon cannot be used, so the work-around test verifies that "Coupon usage limit has been reached." message is displayed.
	  	WebElement couponTextBox = BaseClass.driver.findElement(By.xpath("//*[@class='input-text']"));
	  	couponTextBox.sendKeys("krishnasakinala");
	  	WebElement applyCouponButton = BaseClass.driver.findElement(By.xpath("//*[@class='coupon']/input[2]"));
	  	applyCouponButton.click();
	  	
	  	String couponErrorMsg = BaseClass.driver.findElement(By.xpath("//*[@class='woocommerce-error']")).getText();
	  	Assert.assertEquals(couponErrorMsg, "Coupon usage limit has been reached.");	  	
	  	}
	
	@Test (priority = 10)
  	public void test10() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//work-around - The coupon cannot be used, so the work-around test verifies that the error message "Coupon <wrong coupon name> does not exist." s displayed when a wrong coupon name is entered.
	  	WebElement couponTextBox = BaseClass.driver.findElement(By.xpath("//*[@class='input-text']"));
	  	String wrongCouponName = "wrongCouponNameText";
	  	couponTextBox.sendKeys(wrongCouponName);
	  	WebElement applyCouponButton = BaseClass.driver.findElement(By.xpath("//*[@class='coupon']/input[2]"));
	  	applyCouponButton.click();
	  	
	  	String actualErrorMsg = BaseClass.driver.findElement(By.xpath("//*[@class='woocommerce-error']")).getText();
	  	String expectedErrorMsg = "Coupon \"" + wrongCouponName.toLowerCase() + "\" does not exist!";
	  	Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	  	}
	  	
	@Test (priority = 11)
  	public void test11() {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//remove the item
	  	WebElement removeButton = BaseClass.driver.findElement(By.xpath("//*[@class='shop_table shop_table_responsive cart']/tbody/tr/td[1]/a"));
	  	removeButton.click();
	  	String expectedText = "Your basket is currently empty.";
	  	String actualText = BaseClass.driver.findElement(By.xpath("//*[@class='cart-empty']")).getText();
	  	Assert.assertEquals(actualText, expectedText);
	  	}
	
	@Test (priority = 12)
  	public void test12() throws InterruptedException {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	double amountDescribedDouble = Double.parseDouble(amountDescribedText);
	  	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//update product quantity
	  	WebElement quantityBox = BaseClass.driver.findElement(By.xpath("//*[@class='quantity']/input"));
	  	quantityBox.click();
	  	quantityBox.clear();
	  	quantityBox.sendKeys("5");
	  	WebElement updateBasketButton = BaseClass.driver.findElement(By.xpath("//*[@name='update_cart']"));
	  	updateBasketButton.click();
	  	Thread.sleep(3000);
	  	
	  	//verify amounts
	  	amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	amountInCartText = amountInCart.getText().substring(1);
	  	double amountInCartDouble = Double.parseDouble(amountInCartText);
	  	Assert.assertEquals(amountInCartDouble, (amountDescribedDouble*5));
	}
	
	@Test (priority = 13)
  	public void test13() throws InterruptedException {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	amountInCartText = amountInCart.getText().substring(1);
	  	double amountInCartDouble = Double.parseDouble(amountInCartText);
	  	double expectedTotal = amountInCartDouble + amountInCartDouble*0.05;
	  	
	  	String total = BaseClass.driver.findElement(By.xpath("//tbody/tr[3]/td[1]/strong[1]/span[1]")).getText().substring(1);
	  	double actualTotal = Double.parseDouble(total);
	  	
	  	Assert.assertEquals(actualTotal, expectedTotal);
	}
	
	
	//Test 12 and 14 are duplicates.  The testing website listed duplicate test cases.
	@Test (priority = 14)
  	public void test14() throws InterruptedException {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	double amountDescribedDouble = Double.parseDouble(amountDescribedText);
	  	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//update product quantity
	  	WebElement quantityBox = BaseClass.driver.findElement(By.xpath("//*[@class='quantity']/input"));
	  	quantityBox.click();
	  	quantityBox.clear();
	  	quantityBox.sendKeys("5");
	  	WebElement updateBasketButton = BaseClass.driver.findElement(By.xpath("//*[@name='update_cart']"));
	  	updateBasketButton.click();
	  	Thread.sleep(3000);
	  	
	  	//verify amounts
	  	amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	amountInCartText = amountInCart.getText().substring(1);
	  	double amountInCartDouble = Double.parseDouble(amountInCartText);
	  	Assert.assertEquals(amountInCartDouble, (amountDescribedDouble*5));
	}
	
	@Test (priority = 15)
  	public void test15() throws InterruptedException {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	double amountDescribedDouble = Double.parseDouble(amountDescribedText);
	  	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//update product quantity
	  	WebElement quantityBox = BaseClass.driver.findElement(By.xpath("//*[@class='quantity']/input"));
	  	quantityBox.click();
	  	quantityBox.clear();
	  	quantityBox.sendKeys("5");
	  	WebElement updateBasketButton = BaseClass.driver.findElement(By.xpath("//*[@name='update_cart']"));
	  	updateBasketButton.click();
	  	Thread.sleep(3000);
	  	
	  	//verify if Total amount is greater than the Subtotal amount
	  	
	  	double subTotal = Double.parseDouble(BaseClass.driver.findElement(By.xpath("//*[@class='shop_table shop_table_responsive']/tbody/tr[2]/td/span")).getText().substring(1));
	  	String total = BaseClass.driver.findElement(By.xpath("//tbody/tr[3]/td[1]/strong[1]/span[1]")).getText().substring(1);
	  	double actualTotal = Double.parseDouble(total);
	  	
	  	Assert.assertTrue(actualTotal>subTotal);
	}
	
	@Test (priority = 16)
  	public void test16() throws InterruptedException {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	double amountDescribedDouble = Double.parseDouble(amountDescribedText);
	  	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//update product quantity
	  	WebElement quantityBox = BaseClass.driver.findElement(By.xpath("//*[@class='quantity']/input"));
	  	quantityBox.click();
	  	quantityBox.clear();
	  	quantityBox.sendKeys("5");
	  	WebElement updateBasketButton = BaseClass.driver.findElement(By.xpath("//*[@name='update_cart']"));
	  	updateBasketButton.click();
	  	Thread.sleep(3000);
	  	
	  	//verify that clicking on the Check Out Button will lead to the payment gateway page
	  	WebElement checkOutButton = BaseClass.driver.findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']"));
	  	checkOutButton.click();
	  	
	  	String expectedPaymentGatewayPageURL = "http://practice.automationtesting.in/checkout/";
	  	String actualPaymentGatewayPageURL = BaseClass.driver.getCurrentUrl();
	  	
	  	Assert.assertEquals(actualPaymentGatewayPageURL, expectedPaymentGatewayPageURL);
	  	
	}
	
	@Test (priority = 17)
  	public void test17() throws InterruptedException {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	double amountDescribedDouble = Double.parseDouble(amountDescribedText);
	  	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//update product quantity
	  	WebElement quantityBox = BaseClass.driver.findElement(By.xpath("//*[@class='quantity']/input"));
	  	quantityBox.click();
	  	quantityBox.clear();
	  	quantityBox.sendKeys("5");
	  	WebElement updateBasketButton = BaseClass.driver.findElement(By.xpath("//*[@name='update_cart']"));
	  	updateBasketButton.click();
	  	Thread.sleep(3000);
	  	
	  	//verify that clicking on the Check Out Button will lead to the payment gateway page
	  	WebElement checkOutButton = BaseClass.driver.findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']"));
	  	checkOutButton.click();
	  	
	  	String expectedPaymentGatewayPageURL = "http://practice.automationtesting.in/checkout/";
	  	String actualPaymentGatewayPageURL = BaseClass.driver.getCurrentUrl();
	  	
	  	Assert.assertEquals(actualPaymentGatewayPageURL, expectedPaymentGatewayPageURL);
	  	
	  	//verify Billing Details,Order Details,Additional details and Payment gateway details are displayed
	  	WebElement billingDetails = BaseClass.driver.findElement(By.xpath("//*[@class='woocommerce-billing-fields']"));
	  	Assert.assertTrue(billingDetails.isDisplayed());
	  	WebElement additionalInformation = BaseClass.driver.findElement(By.xpath("//*[@class='woocommerce-shipping-fields']"));
	  	Assert.assertTrue(additionalInformation.isDisplayed());
	  	WebElement orderDetails = BaseClass.driver.findElement(By.xpath("//*[@class='shop_table woocommerce-checkout-review-order-table']"));
	  	Assert.assertTrue(orderDetails.isDisplayed());  	
	  	WebElement paymentMethods = BaseClass.driver.findElement(By.xpath("//*[@class='wc_payment_methods payment_methods methods']"));
	  	Assert.assertTrue(paymentMethods.isDisplayed());
	  	
	}
	
	@Test (priority = 18)
  	public void test18() throws InterruptedException {
		
    	hP.shopButton.click();
    	sP.homeButton.click();    	
    	Assert.assertEquals(3, hP.newArrivalItems.size());
    	hP.newArrival1.click();
    	String newArrival1WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/selenium-ruby/", newArrival1WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival2.click();
    	String newArrival2WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/thinking-in-html/", newArrival2WindowURL);
    	BaseClass.driver.navigate().back();
    	hP.newArrival3.click();
    	String newArrival3WindowURL = BaseClass.driver.getCurrentUrl();
    	Assert.assertEquals("http://practice.automationtesting.in/product/mastering-javascript/", newArrival3WindowURL);
    	
    	//add the first related product to a basket; this is a work-around because the second new arrival item is out of stock and can't be added.
	  	WebElement firstRelatedProduct = BaseClass.driver.findElement(By.xpath("//*[@class='products']/li/a/img"));
	  	firstRelatedProduct.click();
	  	WebElement addToBasket = BaseClass.driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	  	addToBasket.click();
	  	
	  	//verify the item had been added to the basket
	  	WebElement amountInCart = BaseClass.driver.findElement(By.xpath("//*[@class='amount']"));
	  	String amountInCartText = amountInCart.getText().substring(1);
	  	WebElement amountDescribed = BaseClass.driver.findElement(By.xpath("//p[@class='price']//span[@class='woocommerce-Price-amount amount']"));
	  	String amountDescribedText = amountDescribed.getText().substring(1);
	  	Assert.assertEquals(amountDescribedText, amountInCartText);
    	
	  	double amountDescribedDouble = Double.parseDouble(amountDescribedText);
	  	
	  	//click on the Item link
	  	amountInCart.click();
	  	
	  	//update product quantity
	  	WebElement quantityBox = BaseClass.driver.findElement(By.xpath("//*[@class='quantity']/input"));
	  	quantityBox.click();
	  	quantityBox.clear();
	  	quantityBox.sendKeys("5");
	  	WebElement updateBasketButton = BaseClass.driver.findElement(By.xpath("//*[@name='update_cart']"));
	  	updateBasketButton.click();
	  	Thread.sleep(3000);
	  	
	  	//verify that clicking on the Check Out Button will lead to the payment gateway page
	  	WebElement checkOutButton = BaseClass.driver.findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']"));
	  	checkOutButton.click();
	  	
	  	String expectedPaymentGatewayPageURL = "http://practice.automationtesting.in/checkout/";
	  	String actualPaymentGatewayPageURL = BaseClass.driver.getCurrentUrl();
	  	
	  	Assert.assertEquals(actualPaymentGatewayPageURL, expectedPaymentGatewayPageURL);
	  	
	  	//verify Billing Details,Order Details,Additional details and Payment gateway details are displayed
	  	WebElement billingDetails = BaseClass.driver.findElement(By.xpath("//*[@class='woocommerce-billing-fields']"));
	  	Assert.assertTrue(billingDetails.isDisplayed());
	  	WebElement additionalInformation = BaseClass.driver.findElement(By.xpath("//*[@class='woocommerce-shipping-fields']"));
	  	Assert.assertTrue(additionalInformation.isDisplayed());
	  	WebElement orderDetails = BaseClass.driver.findElement(By.xpath("//*[@class='shop_table woocommerce-checkout-review-order-table']"));
	  	Assert.assertTrue(orderDetails.isDisplayed());  	
	  	WebElement paymentMethods = BaseClass.driver.findElement(By.xpath("//*[@class='wc_payment_methods payment_methods methods']"));
	  	Assert.assertTrue(paymentMethods.isDisplayed());
	  	
	  	//enter information on the Payment gateway page
	  	WebElement firstName = BaseClass.driver.findElement(By.id("billing_first_name"));
	  	firstName.sendKeys(BaseClass.getProperties("customerFirstName"));
	  	WebElement lastName = BaseClass.driver.findElement(By.id("billing_last_name"));
	  	lastName.sendKeys(BaseClass.getProperties("customerLastName"));
	  	WebElement email = BaseClass.driver.findElement(By.id("billing_email"));
	  	email.sendKeys(BaseClass.getProperties("customerEmail"));
	  	WebElement phoneNumber = BaseClass.driver.findElement(By.id("billing_phone"));
	  	phoneNumber.sendKeys(BaseClass.getProperties("customerPhoneNumber"));
	  	
	  	WebElement countryDropDown = BaseClass.driver.findElement(By.id("select2-chosen-1"));
	  	countryDropDown.click();
	  	
	  	WebElement country = BaseClass.driver.findElement(By.xpath("//*[@id='select2-results-1']/li[7]"));
	  	country.click();
	  	
	  	WebElement address = BaseClass.driver.findElement(By.id("billing_address_1"));
	  	address.sendKeys(BaseClass.getProperties("customerAddress"));
	  	WebElement city = BaseClass.driver.findElement(By.id("billing_city"));
	  	city.sendKeys(BaseClass.getProperties("customerCity"));
	  	WebElement state = BaseClass.driver.findElement(By.id("billing_state"));
	  	state.sendKeys(BaseClass.getProperties("customerState"));
	  	WebElement zip = BaseClass.driver.findElement(By.id("billing_postcode"));
	  	zip.sendKeys(BaseClass.getProperties("customerZip"));
	  	
	  	//verify all four payment methods are displayed
	  	List<WebElement> paymentMethodRadioButtons = BaseClass.driver.findElements(By.className("//*[@class='wc_payment_methods payment_methods methods']/li"));
	  	for (WebElement paymentMethod: paymentMethodRadioButtons) {
	  		Assert.assertTrue(paymentMethod.isDisplayed() && paymentMethod.isEnabled());
	   	}
	  	
	  	//select Cash on Delivery payment method
	  	WebElement cashPaymentMethod = BaseClass.driver.findElement(By.xpath("//*[@for='payment_method_cod']"));
	  	cashPaymentMethod.click();
	  	
	  	WebElement placeOrderButton = BaseClass.driver.findElement(By.id("place_order"));
	  	placeOrderButton.click();
	}
	
	
}

package My_Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Magento extends Parameters {

	@BeforeTest
	public void MySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = false)
	public void SignUP() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement lastName = driver.findElement(By.id("lastname"));

		WebElement email = driver.findElement(By.cssSelector("#email_address"));

		WebElement password = driver.findElement(By.id("password"));

		WebElement passwordConfirmation = driver.findElement(By.id("password-confirmation"));

		firstName.sendKeys(firstNamesArray[randomNumber]);
		lastName.sendKeys(lastNamesArray[randomNumber]);
		email.sendKeys(UserEmail);
		password.sendKeys(CommonPassword);
		passwordConfirmation.sendKeys(CommonPassword);

		WebElement CreateButton = driver.findElement(By.cssSelector(".action.submit.primary"));
		CreateButton.click();

		String WelcomMsg = driver.findElement(By.className("message-success")).getText();
//			System.out.println(WelcomMsg);
		assertEquals(WelcomMsg, "Thank you for registering with Main Website Store.");

	}

	@Test(priority = 2, enabled = false)
	private void logOut() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		assertEquals(driver.getCurrentUrl().contains("/logoutSuccess/"), true);
	}

	@Test(priority = 3, enabled = false)
	public void SignIn() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(UserEmail);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		String WelcomeMessage = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(WelcomeMessage.contains("Welcome"), true);
	}

	@Test(priority = 1)
	public void SignInMyUser() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("suzan.gh99@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("koko9988@");
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		String WelcomeMessage = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(WelcomeMessage.contains("Welcome"), true);
	}

//	@Test(priority = 4)
//	private void AddEvevBags() throws InterruptedException {
//
//		driver.get("https://magento.softwaretestingboard.com/gear/bags.html");
//		WebElement Products = driver.findElement(By.cssSelector(".column.main"));
//		List<WebElement> items = Products.findElements(By.cssSelector(".item.product.product-item"));
//
//		for (int i = 0; i < items.size(); i += 2) {
//			WebElement numberOfItem = items.get(i);
//
//			WebElement toClick = numberOfItem.findElement(By.className("product-image-photo"));
//			toClick.click();
//			Thread.sleep(4000);
//
//				WebElement addToCartButton = driver.findElement(By.cssSelector(".action.primary.tocart"));
//				addToCartButton.click();
//
//			System.out.println(i);
//		}
//	}

	@Test(priority = 4)
	private void AddEvevBags() throws InterruptedException {
	    driver.get("https://magento.softwaretestingboard.com/gear/bags.html");
	    WebElement Products = driver.findElement(By.cssSelector(".column.main"));
	    List<WebElement> items = Products.findElements(By.cssSelector(".item.product.product-item"));

	    for (int i = 0; i < items.size(); i += 2) {
	        WebElement numberOfItem = items.get(i);
	        WebElement toClick = numberOfItem.findElement(By.className("product-image-photo"));
	        toClick.click();
	        Thread.sleep(4000);

	        // Re-locate the addToCartButton after the click to avoid stale element reference
	        WebElement addToCartButton = driver.findElement(By.cssSelector(".action.primary.tocart"));
	        addToCartButton.click();

	        // Re-locate the Products element to update the list of items
	        Products = driver.findElement(By.cssSelector(".column.main"));
	        items = Products.findElements(By.cssSelector(".item.product.product-item"));

	        System.out.println(i);
	    }
	}

}
















//	@Test(priority = 4)
//	private void AddEvevBags() throws InterruptedException {
//		driver.get("https://magento.softwaretestingboard.com/gear/bags.html");
//		WebElement Products = driver.findElement(By.cssSelector(".column.main"));
//		List<WebElement> items = Products.findElements(By.cssSelector(".item.product.product-item"));
//
//		for (int i = 0; i < items.size(); i += 2) {
//			WebElement numberOfItem = items.get(i);
//
//			WebElement toClick = numberOfItem.findElement(By.className("product-image-photo"));
//			toClick.click();
//			Thread.sleep(4000);
//
//			try {
//				WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
//				addToCartButton.click();
//			} catch (StaleElementReferenceException e) {
//				// Re-locate the button element and click on it
//				driver.navigate().refresh();
//				Thread.sleep(2000);
//				WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
//				addToCartButton.click();
//
//			}
//			System.out.println(i);
//		}
//
//	}

//	---------------------not complete------------------
//	@Test(priority = 4)
//	private void AddEvevBags() throws InterruptedException {
//		driver.get("https://magento.softwaretestingboard.com/gear/bags.html");
//		List<WebElement> Item = driver.findElements(By.cssSelector(".item.product.product-item"));
//
//		for (int i = 0; i < Item.size(); i += 2) {
//			WebElement cart = Item.get(i);
//			WebElement tohover = Item.get(i);
//			action.moveToElement(tohover).perform();
//			Thread.sleep(1000);
//			WebElement Btn = cart.findElement(By.tagName("button")) ;
//			Btn.click();
//			
//			String currentUrl = driver.getCurrentUrl();
//			Thread.sleep(2000);
//			if (currentUrl.contains("gear/bags.html")) {
//				continue;
//			} else {
//				
//				try {
//					
//				} catch (StaleElementReferenceException e) {
//					driver.findElement(By.id("product-addtocart-button")).click(); 
//
//				}
//
//			driver.navigate().back();
//		
//
//			}
//
//			System.out.println(i);
//
//		}
//
//	}

//		System.out.println(AddtoCart.size());
//	for(int i =1  ; i < AddtoCart.size();i+=2) {
//		
//		WebElement cart = AddtoCart.get(i);
//		cart.click();
////		WebElement tohover = AddtoCart.get(i);
////		action.moveToElement(tohover).perform();
////		Thread.sleep(3000);
////		driver.findElement(By.cssSelector(".action.tocart.primary")).click();
////		driver.findElement(By.cssSelector(".price-box.price-final_price")).click();
//
//		Thread.sleep(2000);
//		driver.findElement(By.id("product-addtocart-button")).click();
//		System.out.println(i);
//		driver.navigate().refresh();
//		driver.get("https://magento.softwaretestingboard.com/gear/bags.html");
//		
//	}
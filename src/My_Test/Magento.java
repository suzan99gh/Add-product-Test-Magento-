package My_Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

	@Test(priority = 1)
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

	@Test(priority = 2)
	private void logOut() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		assertEquals(driver.getCurrentUrl().contains("/logoutSuccess/"), true);
	}

	@Test(priority = 3)
	public void SignIn() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(UserEmail);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		String WelcomeMessage = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(WelcomeMessage.contains("Welcome"), true);
	}
	
//	---------------------not complete------------------
	@Test (priority = 4) 
	private void AddEvevBags() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/gear/bags.html");
	List<WebElement> AddtoCart  = driver.findElements(By.cssSelector(".item.product.product-item"))  ;
		System.out.println(AddtoCart.size());
	for(int i =1  ; i < AddtoCart.size();i+=2) {
		
		WebElement cart = AddtoCart.get(i);
		cart.click();
//		WebElement tohover = AddtoCart.get(i);
//		action.moveToElement(tohover).perform();
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector(".action.tocart.primary")).click();
//		driver.findElement(By.cssSelector(".price-box.price-final_price")).click();

		Thread.sleep(2000);
		driver.findElement(By.id("product-addtocart-button")).click();
		driver.navigate().back();
	}

	}

}

package My_Test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	String URL = "https://magento.softwaretestingboard.com/";
	Actions action = new Actions(driver);
	Random rand = new Random();

	int randomNumber = rand.nextInt(5);
	int RandomNumberForEmail =rand.nextInt(555);

	// Array of first names
	String[] firstNamesArray = { "John", "Emily", "Michael", "Sophia", "Daniel" };

	// Array of last names
	String[] lastNamesArray = { "Smith", "Johnson", "Williams", "Brown", "Jones" };

	String UserEmail = firstNamesArray[randomNumber] + lastNamesArray[randomNumber]+RandomNumberForEmail + "@gmail.com";
	String CommonPassword = "ku323@889KH";
}

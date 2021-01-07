package Week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelecteableAUI {

	public static void main(String[] args) {
		// Precondition to start the webdriver
WebDriverManager.chromedriver().setup();
//Open chrome browser
ChromeDriver driver = new ChromeDriver();
//maximizing the browser
driver.manage().window().maximize();
//Load the url
driver.get("http://leafground.com/pages/selectable.html");
WebElement item5 = driver.findElementByXPath("//li[text()='Item 5']");
WebElement item6 = driver.findElementByXPath("//li[text()='Item 6']");
WebElement item7 = driver.findElementByXPath("//li[text()='Item 7']");

 Actions builder = new Actions(driver);
 builder.clickAndHold(item5).moveToElement(item7).release().perform();
 
	}

}

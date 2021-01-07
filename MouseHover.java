package Week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// Precondition to start the webdriver
WebDriverManager.chromedriver().setup();
ChromeOptions Options = new ChromeOptions();
Options.addArguments("--disable notifications");

//Open chrome browser
ChromeDriver driver = new ChromeDriver(Options);
//maximizing the browser
driver.manage().window().maximize();
//Load the url
driver.get("https://www.snapdeal.com/");
WebElement Men = driver.findElementByXPath("(//span[@class='catText'][contains(text(),'Fashion')])[1]");
Actions builder = new Actions(driver);
builder.moveToElement(Men).perform();
Thread.sleep(10000);
driver.findElementByXPath("(//a[@class='rightMenuLink  noHasTagWidth dp-widget-link']/span[text()='Shirts'])[2]").click();

WebElement quickView = driver.findElementByXPath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']");
builder.moveToElement(quickView).click().perform();
Thread.sleep(3000);
driver.close(); 	

	}

}

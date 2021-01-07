package wweek4.day2;




import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		    ChromeDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("http://leafground.com/pages/TextChange.html");
		    WebElement  webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']")));
			webDriverWait.click();
		    Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			String VerificationText="Click ME!";
			if(text.equals(VerificationText)) {
				alert.accept();
			}
			 driver.close();
	}

}



  
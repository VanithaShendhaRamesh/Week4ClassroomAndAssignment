package Week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentCalender {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			 driver.get("http://leafground.com/pages/Calendar.html");
			 Thread.sleep(3000);
			 driver.findElementById("datepicker").click();
			 Thread.sleep(3000);
			 driver.findElementByXPath("//table/tbody/tr[3]/td[1]/a").click();
			 Thread.sleep(3000);
			 driver.close();

	}

}

package Week4.day1;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	   ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("http://leafground.com/pages/table.html");
		List<WebElement> tableColumn = driver.findElementsByXPath("//table[@id='table_id']/tbody/tr[2]/td");
		List<WebElement> tablerow = driver.findElementsByXPath("//table[@id='table_id']/tbody/tr");
		System.out.println("column : "+ tableColumn.size());
		System.out.println("row : "+ tablerow.size());
		String progressValue = driver.findElementByXPath("//table[@id='table_id']/tbody/tr[3]/td[2]").getText();
		System.out.println("progressValue : "+ progressValue);
		driver.findElementByXPath("(//input[@type='checkbox'])[3]").click();
		
		driver.close();
	
		

	}

	

	
	}



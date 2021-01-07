package wweek4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		    ChromeDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("http://leafground.com/pages/Window.html");
		   
		  /*  WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
			  webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//button[text()='Wait for 5 seconds']"))).click();*/
			 
		    driver.findElementById("home").click();
		    driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
		    driver.findElementByXPath("//button[text()='Do not close me ']").click();
		    driver.findElementByXPath("//button[text()='Wait for 5 seconds']").click();
		    Set<String> windowHandles = driver.getWindowHandles();
		    List<String> Handles = new ArrayList<String>(windowHandles);
		    
		    String first = Handles.get(0);
		    driver.switchTo().window(first);
		    System.out.println(driver.getTitle()); 
		    driver.close();
		    String second = Handles.get(1);
		    driver.switchTo().window(second);
		    System.out.println(driver.getTitle()); 
		    String third = Handles.get(2);
		    driver.switchTo().window(third);
		    System.out.println(driver.getTitle()); 
		    driver.close();
		    String fourth = Handles.get(3);
		    driver.switchTo().window(fourth);
		    System.out.println(driver.getTitle());
		    String fifth = Handles.get(4);
		    driver.switchTo().window(fifth);
		    System.out.println(driver.getTitle()); 
		    driver.close();
		    String sixth = Handles.get(5);
		    driver.switchTo().window(sixth);
		    System.out.println(driver.getTitle());
		    driver.close();
		    String seventh = Handles.get(6);
		    driver.switchTo().window(seventh);
		    System.out.println(driver.getTitle());
		    driver.close();
		    String eight = Handles.get(7);
		    driver.switchTo().window(eight);
		    System.out.println(driver.getTitle());
		    driver.close();
		    int NoOfWindows = Handles.size();
		    System.out.println(NoOfWindows);
		   /* WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
			webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//button[text()='Wait for 5 seconds']"))).click();*/
	
	}

}

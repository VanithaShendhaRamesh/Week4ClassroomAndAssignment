package wweek4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://leaftaps.com/opentaps/control/main");
	    driver.findElementById("username").sendKeys("DemoSalesManager");
	    driver.findElementById("password").sendKeys("crmsfa");
	    driver.findElementByXPath("//input[@value='Login']").click();
	    driver.findElementById("label").click();
	    driver.findElementByLinkText("Leads").click();
	    driver.findElementByLinkText("Merge Leads").click();
	    driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> Handles = new ArrayList<String>(windowHandles);
	    String second = Handles.get(1);
	    driver.switchTo().window(second);
	    System.out.println(driver.getTitle()); 
	    driver.findElementByXPath("//input[@name='id']").sendKeys("10138");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElementByXPath("//a[text()='10138']").click();
	    String first = Handles.get(0);
	    driver.switchTo().window(first);
	    driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
	    Set<String> windowHandles1 = driver.getWindowHandles();
	    List<String> Handles1 = new ArrayList<String>(windowHandles1);
		    String secondToLead = Handles1.get(1);
		    driver.switchTo().window(secondToLead);
		    System.out.println(driver.getTitle()); 
		    driver.findElementByXPath("//input[@name='id']").sendKeys("10136");
		    driver.findElementByXPath("//button[text()='Find Leads']").click();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.findElementByXPath("//a[text()='10136']").click();
		    String firstToLead = Handles1.get(0);
		    driver.switchTo().window(firstToLead);
		    driver.findElementByLinkText("Merge").click();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.switchTo().alert().accept();
		    driver.findElementByLinkText("Find Leads").click();
		    driver.findElementByXPath("//input[@name='id']").sendKeys("10138");
		    driver.findElementByXPath("//button[text()='Find Leads']").click();
		 String verificationText="No records to display";
		 String text = driver.findElementByXPath("//div[text()='No records to display']").getText();
		 if(verificationText.equals(text)) {
		 System.out.println("Merge is Successful");
		 }
	    driver.close();
	    
	 
	  
	  
	    
	    

	}

}

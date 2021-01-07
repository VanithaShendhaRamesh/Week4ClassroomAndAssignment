package wweek4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlesAndScreenShot {
	public static void main(String[] args) throws IOException {
		  WebDriverManager.chromedriver().setup();
		    ChromeDriver driver = new ChromeDriver();
		     driver.manage().window().maximize();
		    driver.get("https://www.irctc.co.in/nget/train-search");
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElementByXPath("//button[text()='OK']").click();
		 driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		 String windowHandle = driver.getWindowHandle();
		 Set<String> windowHandles = driver.getWindowHandles();
		List<String> allHandles = new ArrayList<String>(windowHandles);
		/*for (String temphandles : allHandles) {
			System.out.println(temphandles);
			
		}*/
		String secondHandle = allHandles.get(1);
		driver.switchTo().window(secondHandle);
		WebElement emailId = driver.findElementByXPath("//div[@class='navbar-nav-right text-center text-sm-center text-md-right ']/div[2]/a");
		//System.out.println(text);  
	//SCreenShot
		File source = emailId.getScreenshotAs(OutputType.FILE);
		File target = new File("E:\\Testleaf\\page.png");
		FileUtils.copyFile(source, target);
		driver.quit();//close all window opened by selenium
	}
}

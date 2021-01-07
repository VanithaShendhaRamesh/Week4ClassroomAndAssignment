package wweek4.day2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAndFrames {
  public static void main(String[] args) throws InterruptedException {
    // Precondition to start the webdriver
    WebDriverManager.chromedriver().setup();
    //Open chrome browser
    ChromeDriver driver = new ChromeDriver();
    //maximizing the browser
    driver.manage().window().maximize();
    //Load the url
    driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.switchTo().frame("iframeResult");
    WebElement element = driver.findElementByXPath("//button[text()='Try it']");
    element.click();
    driver.switchTo().alert().sendKeys("vanitha");
    Thread.sleep(5000);
    driver.switchTo().alert().accept();
    String text = driver.findElementByXPath("//p[@id='demo']").getText();
    Thread.sleep(5000);
  //System.out.println(text);
    String verificationText = "Hello vanitha! How are you today?";
  //System.out.println(verificationText);
    Thread.sleep(5000);
    if (text.equals(verificationText)) {
      System.out.println("verified");
    } else {
      System.out.println("Not Verified");
    }
    driver.close();
  }

}
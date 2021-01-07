package wweek4.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    driver.manage().window().maximize();
    driver.get("https://dev68594.service-now.com/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.switchTo().frame(0);
    driver.findElementById("user_name").sendKeys("admin");
    Actions builder = new Actions(driver);
    // builder.moveToElement(user_name).click().perform();
    //user_name.sendKeys("admin");
    driver.findElementById("user_password").sendKeys("India@123");
    driver.findElementByXPath("//button[text()='Login']").click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElementById("filter").sendKeys("incident");
    js.executeScript("window.scrollBy(0,600)");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebElement aLL = driver.findElementByXPath("(//div[@class='sn-widget-list_v2 sn-widget-list_dense']/div/a/div/div[text()='All'])[2]");
    builder.moveToElement(aLL).click().perform();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.switchTo().frame(0);
    driver.findElementByXPath("//button[text()='New']").click();
    driver.findElementById("sys_display.incident.caller_id").sendKeys("System" + Keys.ARROW_DOWN + Keys.ENTER);
    driver.findElementById("incident.short_description").sendKeys("Submitting a Test Incident Ticket");
    WebElement incident = driver.findElementById("incident.number");
    String incidentNumber = incident.getAttribute("value");
    driver.findElementByXPath("(//button[text()='Submit'])[1]").click();
    WebElement closeBtn = driver.findElementById("close-messages-btn");

    if (closeBtn.isDisplayed()) {

      System.out.println("in");

      Thread.sleep(6000);
      builder.moveToElement(closeBtn).click().perform();
      Thread.sleep(6000);
      //closeBtn.click();
      //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      // new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(findElementByCssSelector("(//button[text()='Submit'])[1]"))).click();
      driver.findElementByXPath("(//button[text()='Submit'])[1]").click();
    }
    //System.out.println("out");
    Thread.sleep(6000);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElementByXPath("//div[@class='input-group']/input").sendKeys(incidentNumber + Keys.ENTER);
    WebElement incidentNumber1 = driver.findElementByLinkText(incidentNumber);
    if (incidentNumber1.isDisplayed()) {
      System.out.println("Incident Ticket Submitted");
    }

    driver.close();

  }


}
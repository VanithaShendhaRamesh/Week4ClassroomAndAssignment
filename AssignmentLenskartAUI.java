package Week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentLenskartAUI {

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.lenskart.com");
    Thread.sleep(3000);
    Integer highestValue = null;
    Actions builder = new Actions(driver);
    //3. Mouse Hover "Computer Glasses"-->MEN-->Click Premium Range
    WebElement computerGlasses = driver.findElementByXPath("//a[text()='Computer Glasses']");
    WebElement men = driver.findElementByXPath("(//span[text()='men'])[2]");
    WebElement premiumRange = driver.findElementByXPath("(//span[text()='PREMIUM RANGE'])[1]");
    builder.moveToElement(computerGlasses).perform();
    builder.moveToElement(men).perform();
    builder.moveToElement(premiumRange).click().perform();
    //4. Click Round(Frame Shape)
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElementByXPath("//span[@title='Round']").click();
   // 5. Click on Frame color with highest count--Since the Frame Color is string ,so separating the int from string to find the highest value of the frame color
    List < String > glassColor = new ArrayList < String > ();
    Thread.sleep(6000);
    for (int i = 1; i < 15; i++) {
      String color = driver.findElementByXPath("//*[@id='categoryPage']/div[4]/div[1]/div/div/div[4]/div/ul/li[" + i + "]/div/label/span").getText();
      String colorNumber = color.replaceAll("\\D", "");
      glassColor.add(colorNumber);
    }
    List < Integer > glassColorvalue = new ArrayList < Integer > ();
    for (String tmp: glassColor) {
      glassColorvalue.add(Integer.valueOf(tmp));
    }
    Collections.sort(glassColorvalue);
    for (int i = 0; i < glassColorvalue.size(); i++) {
      highestValue = glassColorvalue.get(i);
    }

    System.out.println(highestValue);
    String highestValues = Integer.toString(highestValue);
    //Clicking the frame color of highest count
    for (int i = 1; i < 15; i++) {
      String color = driver.findElementByXPath("//*[@id='categoryPage']/div[4]/div[1]/div/div/div[4]/div/ul/li[" + i + "]/div/label/span").getText();
      String colorNumber = color.replaceAll("\\D", "");
      if (colorNumber.equals(highestValues)) {
        builder.moveToElement(driver.findElementByXPath("//span[text()='" + color + "']/preceding-sibling::input")).doubleClick().perform();

      }

    }
    //6. Confirm the count shown in the frame color matches the displayed results count
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String displayCount = driver.findElementByClassName("show_count").getText();
    if (displayCount.contains(highestValues)) {
      System.out.println("Displaying all " + highestValues + "Results");
      //Print the size of the first product (Hint: Mouse hover on the prouct to get the size)
      //			driver.findElementByXPath("//img[@class='img-responsive']").click();
      //			System.out.println("Description:"+ driver.getTitle());
      /*WebElement size = driver.findElementByXPath("(//p[@class='fs12 no-decoration text-black margin-b0 inline-block']/span)[1]");
      builder.moveToElement(size).build().perform();	
		String sizeValue = size.getText();
		System.out.println("size"+sizeValue);*/
    }
    driver.close();

  }

}
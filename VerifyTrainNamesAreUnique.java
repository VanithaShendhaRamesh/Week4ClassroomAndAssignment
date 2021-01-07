package Week4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTrainNamesAreUnique {

  public static void main(String[] args) throws InterruptedException {
    // Precondition to start the webdriver
    WebDriverManager.chromedriver().setup();
    //Open chrome browser
    ChromeDriver driver = new ChromeDriver();
    //maximizing the browser
    driver.manage().window().maximize();
    //Load the url
    driver.get("https://erail.in/");
    driver.findElementById("txtStationFrom").clear();
    driver.findElementById("txtStationFrom").sendKeys("ms");
    driver.findElementById("txtStationFrom").sendKeys(Keys.TAB);
    driver.findElementById("txtStationTo").clear();
    driver.findElementById("txtStationTo").sendKeys("mdu");
    driver.findElementById("txtStationTo").sendKeys(Keys.TAB);

    Thread.sleep(2000);
    driver.findElementById("chkSelectDateOnly").click();
    Thread.sleep(2000);
    List < WebElement > trainNamerow = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");

    int size = trainNamerow.size();
    List < String > trainNames = new ArrayList < String > ();
    for (int i = 1; i < size; i++) {

      String trainName = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]").getText();
      trainNames.add(trainName);
    };
    Set < String > trainsuniqueName = new LinkedHashSet < String > ();

    int size1 = trainsuniqueName.size();
    if (size != size1) {
      System.out.println("Trains name are not unique");
    } else {
      System.out.println("Trains name are unique");
    }

    driver.close();
  }

}
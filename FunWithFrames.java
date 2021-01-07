package wweek4.day2;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunWithFrames {

  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://leafground.com/pages/frame.html");
    driver.switchTo().frame(0);
    driver.findElementByTagName("button").click();
    driver.switchTo().defaultContent();
    driver.switchTo().frame(1);
    driver.switchTo().frame("frame2");
    driver.findElementByTagName("button").click();
    driver.switchTo().defaultContent();
    int Outerframe = driver.findElementsByTagName("iframe").size();
    //System.out.println(Outerframe);
    int innerframe = 0;
    int Totalframe = 0;
    for (int i = 0; i < Outerframe; i++) {
      driver.switchTo().frame(i);
      int total = driver.findElementsByTagName("iframe").size();
      innerframe = innerframe + total;
      driver.switchTo().defaultContent();
    }
    Totalframe = Outerframe + innerframe;
    System.out.println("TotalFrame in the page:" + Totalframe);
    driver.close();

  }

}
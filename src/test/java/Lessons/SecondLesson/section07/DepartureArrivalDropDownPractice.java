package Lessons.SecondLesson.section07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DepartureArrivalDropDownPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //opening url
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Finding Departure City click
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        //Finding Bengalaru(BLR) city and click
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        //driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();

        //Finding Kishangard(KQH) city and click
        driver.findElement(By.xpath("(//a[@value='KQH'])[2]")).click();
        //driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='VNS']")).click();

        //id="ctl00_mainContent_ddl_originStation1_CTNR


    }
}

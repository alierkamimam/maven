package Homework.Lesson01_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase07 {
    public static void main(String[] args) throws InterruptedException {
        //TestCase07 : Click the 'Paul Brown' checkbox and
        //Click to 'Delete Selected' button

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        //Valid username
        driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");
        //Invalid username
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        //click the login button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
        Thread.sleep(1);
        //Click the 'Paul Brown' checkbox
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
        //Click to 'Delete Selected' button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']")).click();
        Thread.sleep(4000);

        driver.quit();


    }
}

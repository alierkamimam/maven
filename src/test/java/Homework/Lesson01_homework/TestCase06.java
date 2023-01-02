package Homework.Lesson01_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase06 {
    public static void main(String[] args) throws InterruptedException {
        //TestCase06: Checking 'Uncheck Button'

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        //Valid username
        driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");

        //Invalid username
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //click the login button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();


        //click the 'check all' button
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        Thread.sleep(2000);

        //click the 'uncheck all' button
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']")).click();
        Thread.sleep(2000);

        driver.quit();

    }
}
package Homework.Lesson01_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase08 {
    public static void main(String[] args) throws InterruptedException {

        //TestCase08 : Take Card Number of Steve Jobs

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
        //Take Card Number of Steve Jobs
        String cardNumberOfSteveJobs = driver.findElement(By.xpath("//td[normalize-space()='444555444555']")).getText();
        //Print card number
        System.out.println(cardNumberOfSteveJobs);


        //Check whether test passed or failed
        if (cardNumberOfSteveJobs.equals("444555444555")) {
            System.out.println("test passed");
        } else
            System.out.println("Test failed");
        driver.quit();
    }
}

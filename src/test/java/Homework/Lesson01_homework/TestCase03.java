package Homework.Lesson01_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class TestCase03 {
    public static void main(String[] args) {
        //Test Scenario 1:Login Page
        //Test Case 1: Valid username, valid password
        //Test Case 2: Valid username , invalid password
        //Test Case 3: Invalid username, invalid password


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        //Valid username
        driver.findElement(By.xpath("//input[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester1");

        //Invalid password
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //click the login button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();

        //get message text
        String actual = driver.findElement(By.id("ctl00_MainContent_status")).getText();


        //compare expected - actual result
        if (actual.equals("Invalid Login or Password.")) {
            System.out.println("Test passed");
        } else
            System.out.println("Test failed");
        // close the  browser
        driver.quit();


    }
}



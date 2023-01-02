package Homework.Lesson01_homework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class TestCase01 {
    public static void main(String[] args) throws InterruptedException {
        //Test Scenario 1:Login Page
        //Test Case 1: Valid username, valid password
        //Test Case 2: Valid username , invalid password
        //Test Case 3: Invalid username, invalid password


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
        //get URL
        String actual = driver.getCurrentUrl();


        if (actual.equals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/")) {
            System.out.println("Test passed");
        } else
            System.out.println("Test failed");


        driver.close();


    }

}


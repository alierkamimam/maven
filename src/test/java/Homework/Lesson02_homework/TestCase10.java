package Homework.Lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase10 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userNameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        userNameBox.sendKeys("locked_out_user");
        passwordBox.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String actualLockedUserAlert = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        System.out.println(actualLockedUserAlert);

        Assert.assertEquals(actualLockedUserAlert, "Epic sadface: Sorry, this user has been locked out.");
        System.out.println("assert passed");
    }
}

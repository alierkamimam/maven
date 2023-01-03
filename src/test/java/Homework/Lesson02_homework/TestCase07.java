package Homework.Lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase07 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement lastName = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userName.sendKeys("problem_user");
        lastName.sendKeys("secret_sauce");
        loginButton.click();

        WebElement img = driver.findElement(By.cssSelector("img[src='/static/media/sl-404.168b1cce.jpg'] "));
        img.click();
        ///static/media/sl-404.168b1cce.jpg
        //img[src='/static/media/sauce-pullover-1200x1500.439fc934.jpg
        WebElement img1 = driver.findElement(By.cssSelector("img[src='/static/media/sauce-pullover-1200x1500.439fc934.jpg']"));

        Assert.assertEquals(img1, img);

    }

}

package Homework.Lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestCase01 {
    public static void main(String[] args) {
          /*Test scenario:Login Page
        TestCase01:Valid username, Valid passwd
        TestCase02:Valid username, Invalid passwd
        TestCase03:Invalid username, Valid passwd

        */

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement userNameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        //TestCase01:Valid username, Valid passwd

        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        WebElement sauceLabsOneSieClickButton = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        sauceLabsOneSieClickButton.click();

        driver.findElement(By.className("shopping_cart_link")).click();

        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();


        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement zipPostalCode = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.id("continue"));


        firstName.sendKeys("Ali Erkam");
        lastName.sendKeys("Imam");
        zipPostalCode.sendKeys("06300");
        continueButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");

        WebElement finishedButton = driver.findElement(By.id("finish"));
        finishedButton.click();

        WebElement finishedMessage = driver.findElement(By.className("complete-header"));


        Assert.assertEquals(finishedMessage.getText(), "THANK YOU FOR YOUR ORDER");

        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        backHomeButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        driver.quit();


    }

}

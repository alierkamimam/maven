package Homework.Lesson02_homework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TestCase04 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");

        WebElement userNameBox = driver.findElement(By.id("user-name"));
        WebElement passWordBox = driver.findElement(By.id("password"));

        userNameBox.sendKeys("standard_user");
        passWordBox.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
        List<WebElement> addButtons = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

        //Click every "add to cart" button
        for (WebElement addButton : addButtons) {
            addButton.click();
        }

        String numberInShoppingCart = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();

        Assert.assertEquals(addButtons.size() + "", numberInShoppingCart);

        //Romove 2 items and check number in shopping cart
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']")).click();

        String numberInShoppingCart2 = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();

        Assert.assertEquals((addButtons.size() - 2) + "", numberInShoppingCart2);

        driver.quit();
    }
}
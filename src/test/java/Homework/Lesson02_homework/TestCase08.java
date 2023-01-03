package Homework.Lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestCase08 {
    public static void main(String[] args) {


        // Set up the web driver
        WebDriver driver = new ChromeDriver();

// Navigate to the login page
        driver.get("https://www.saucedemo.com/");

// Maximize the window
        driver.manage().window().maximize();


        // Enter the username and password
        WebElement usernameField = driver.findElement(By.cssSelector("[type='text']"));
        usernameField.sendKeys("problem_user");
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys("secret_sauce");

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Click the login button
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();


        // Select all items
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".btn_primary"));
        for (int i = 0; i < addToCartButtons.size(); i++) {
            addToCartButtons.get(i).click();

        }

        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        List<WebElement> cartList = driver.findElements(By.cssSelector(".inventory_item_name"));
        System.out.println("working add to chart buttons' products are:");

        for (int i = 0; i < cartList.size(); i++) {
            System.out.println(cartList.get(i).getText());
        }


    }
}
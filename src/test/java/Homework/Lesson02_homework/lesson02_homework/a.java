package Homework.Lesson02_homework.lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class a {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement UserName = driver.findElement(By.id("user-name"));
        UserName.sendKeys("standard_user");

        WebElement lastName = driver.findElement(By.id("password"));
        lastName.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        List<WebElement> addButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        List<WebElement> itemsNameElement=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> itemsName=new ArrayList<>();


        for (WebElement addbutton : addButtons) {

            System.out.println(addbutton);
            addbutton.click();

        }





        System.out.println(driver.findElement(By.className("shopping_cart_badge")).getText());
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(),"6");


    }
}

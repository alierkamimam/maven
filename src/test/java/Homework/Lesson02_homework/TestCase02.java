package Homework.Lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestCase02 {
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

        List<WebElement> itemsNameElement = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> itemsName = new ArrayList<>();

        for (WebElement addButton : addButtons) {

            addButton.click();

            System.out.println();

        }


        for (WebElement item : itemsNameElement
        ) {

            itemsName.add(item.getText());
        }


        driver.findElement(By.className("shopping_cart_link")).click();


        List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));
        List<String> cartItemsName = new ArrayList<>();

        for (WebElement cartItem : cartItems) {

            cartItemsName.add(cartItem.getText());

        }

        if (cartItemsName.size() != itemsName.size()) {

            System.out.println("False");

        } else {

            for (int i = 0; i < itemsName.size(); i++) {

                System.out.print(cartItemsName.get(i));
                System.out.println("----------" + itemsName.get(i));


                if (!cartItemsName.get(i).equalsIgnoreCase(itemsName.get(i))) {

                    System.out.println("İsim uyuşmuyor");
                }

            }
        }
    }
}
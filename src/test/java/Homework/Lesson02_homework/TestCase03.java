package Homework.Lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestCase03 {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userNameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();


        List<String> nameFromFirstPage = new ArrayList<>();
        List<String> priceFromFirstPage = new ArrayList<>();


        List<WebElement> priceFromFirstPageElementList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<WebElement> nameElementFromFirstPageList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<WebElement> addButtonsList = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

        for (int i = 0; i < priceFromFirstPageElementList.size(); i++) {
            nameFromFirstPage.add(nameElementFromFirstPageList.get(i).getText());
            priceFromFirstPage.add(priceFromFirstPageElementList.get(i).getText());
        }


        for (WebElement addButton : addButtonsList) {
            addButton.click();
        }

        // Click cart Symbol

        WebElement cartSymbol = driver.findElement(By.className("shopping_cart_link"));

        cartSymbol.click();

        List<WebElement> priceFromCartPageElement = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<WebElement> nameElementFromCartPage = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));


        if (nameFromFirstPage.size() != nameElementFromCartPage.size()) {
            System.out.println("productNumber is wrong");
        } else {
            for (int i = 0; i < nameFromFirstPage.size(); i++) {
                String priceAndNameFromFirstPage = nameFromFirstPage.get(i) + "-" + priceFromFirstPage.get(i);
                String priceAndNameFromCartPage = nameElementFromCartPage.get(i).getText() + "-" + priceFromCartPageElement.get(i).getText();

                System.out.print(priceAndNameFromFirstPage + " <--> ");
                System.out.println(priceAndNameFromCartPage);

                if (!priceAndNameFromFirstPage.equalsIgnoreCase(priceAndNameFromFirstPage)) {
                    System.out.println("There is a price tag mistake! Step : " + i);
                }
            }
        }

        driver.close();

    }
}


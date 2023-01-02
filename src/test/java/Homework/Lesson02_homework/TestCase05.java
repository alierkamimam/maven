package Homework.Lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class TestCase05 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userNameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        Select orderSelector = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        orderSelector.selectByIndex(1);

        List<WebElement> nameElementFromFirstPageList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> nameFromFirstPage = new ArrayList<>();

        for (int i = 0; i < nameElementFromFirstPageList.size(); i++) {
            nameFromFirstPage.add(nameElementFromFirstPageList.get(i).getText());
        }

        for (int i = 0; i < nameFromFirstPage.size() - 1; i++) {
            if (nameFromFirstPage.get(i).compareTo(nameFromFirstPage.get(i + 1)) < 0) {
                System.out.print(nameFromFirstPage.get(i) + "'s place is wrong!");
                driver.close();
                System.exit(1);
            }
        }

        System.out.println(nameElementFromFirstPageList.get(nameFromFirstPage.size() - 1));
        System.out.println("Order is true!");

        driver.close();
    }
}

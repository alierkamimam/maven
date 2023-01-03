package Homework.Lesson02_homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase09 {


    public static void main(String[] args) throws InterruptedException {

        //system logins
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.className("product_sort_container")).click();


        System.out.println("---------------------");

        //lists the products on the page
        List<WebElement> itemsNameElement = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> itemsName = new ArrayList<>();
        for (WebElement item : itemsNameElement
        ) {
            itemsName.add(item.getText());
        }

        //sort the products from z to a
        Collections.sort(itemsName, Collections.reverseOrder());


        //sort from z to a with the sort button
        driver.findElement(By.xpath("//select/option[@value='za']")).click();
        List<WebElement> itemsNameElement_order = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> itemsName_order = new ArrayList<>();


        //list sorted products
        for (WebElement item_order : itemsNameElement_order
        ) {
            itemsName_order.add(item_order.getText());
        }


        //compare the two lists
        for (int i = 0; i < itemsName_order.size(); i++) {
            if (itemsName_order.get(i).equals(itemsName.get(i))) {

            } else {
                System.out.println("sorting works incorrectly");
                break;
            }
        }
    }
}


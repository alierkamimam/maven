package Lessons.Week03.Section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class FilterWebTable {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        WebElement search = driver.findElement(By.id("search-field"));
        search.sendKeys("Rice");

        List<WebElement> vegFruitTable = driver.findElements(By.xpath("//tr/td[1]"));
        //1 elements


        List<WebElement> filteredList = vegFruitTable.stream().filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());
                //1 result

        Assert.assertEquals(vegFruitTable,filteredList);




    }
}

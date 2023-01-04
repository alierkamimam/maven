package Lessons.Week03.Section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class TableSortingGreenCardWebSite {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on column
        WebElement veg_FruitName = driver.findElement(By.xpath("//tr/th[1]"));
        veg_FruitName.click();

        //capture all web-elements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all web-elements into new list
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        //sort on the original list of step 3-> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        // Assert.assertEquals(originalList,sortedList);-> we can use it
        Assert.assertTrue(originalList.equals(sortedList));
        List<String> price;

// scan the name column with getText ->Beans->print the price of the Rice

        do

        {

            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            price = rows.stream().filter(s -> s.getText().contains("Rice"))

                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            if(price.size()<1)

            {

                driver.findElement(By.cssSelector("[aria-label='Next']")).click();

            }

        }while(price.size()<1);


        driver.quit();
    }

    private static String getPriceVeggie(WebElement s) {
        String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }


}

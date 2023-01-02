package Lessons.SecondLesson.section07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiveDropDownPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Assignment to country which 'COUNTRY' autosuggestive dropdown
        WebElement country = driver.findElement(By.id("autosuggest"));
        country.sendKeys("ind");

        //creating List and assign to list
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']  a"));

        //finding Requested word for matching
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {

                option.click();
                break;
            }

        }
    }
}

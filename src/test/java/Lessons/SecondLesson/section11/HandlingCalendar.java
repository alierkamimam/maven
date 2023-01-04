package Lessons.SecondLesson.section11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingCalendar {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        Thread.sleep(2000);
        WebElement calendar = driver.findElement(By.id("form-field-travel_comp_date"));
        calendar.click();
        WebElement month = driver.findElement(By.cssSelector("[class='flatpickr-month'] [class='cur-month']"));

        while (!driver.findElement(By.cssSelector("[class='flatpickr-month'] [class='cur-month']")).getText().contains("April")) {
            driver.findElement(By.cssSelector("[class='flatpickr-month'] [class='flatpickr-next-month']")).click();
            Thread.sleep(300);
        }


        List<WebElement> inCalendar = driver.findElements(By.cssSelector("span[class*='flatpickr-day ']"));


        for (int i = 0; i < inCalendar.size(); i++) {
            String text = inCalendar.get(i).getText();
            if (text.equalsIgnoreCase("23")) {
                inCalendar.get(i).click();
                break;
            }


        }


    }
}


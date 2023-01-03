package Lessons.SecondLesson.section09;

import com.sun.org.apache.bcel.internal.generic.LADD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Homework {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement userName = driver.findElement(By.id("username"));
        WebElement lastName = driver.findElement(By.id("password"));
        WebElement userButton = driver.findElement(By.xpath("(//span[@class='checkmark'])[2]"));

        userName.sendKeys("rahulshettyacademy");
        lastName.sendKeys("learning");
        userButton.click();

        w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

        WebElement job = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[5]/select"));
        Select dx = new Select(job);
        dx.selectByIndex(1);


        WebElement checkBox = driver.findElement(By.id("terms"));
        checkBox.click();

        WebElement signButton = driver.findElement(By.id("signInBtn"));
        signButton.click();

        Thread.sleep(2000);

        List<WebElement> addButton = driver.findElements(By.cssSelector(".btn-info"));

        for (WebElement add : addButton) {

            add.click();
        }

    }
}

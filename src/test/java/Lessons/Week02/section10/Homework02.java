package Lessons.Week02.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        WebElement nestedFrames = driver.findElement(By.cssSelector("a[href='/nested_frames']"));
        nestedFrames.click();


        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String s = driver.findElement(By.id("content")).getText();
        System.out.println(s);


    }
}

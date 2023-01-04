package Lessons.Week02.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class ActionDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();


        Actions a = new Actions(driver);
        WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click()
                .keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        //Moves to Specific  Element
        a.moveToElement(move).contextClick().build().perform();



    }
}

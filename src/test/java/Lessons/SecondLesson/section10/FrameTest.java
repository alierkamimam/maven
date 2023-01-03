package Lessons.SecondLesson.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        WebElement drag = driver.findElement(By.id("draggable"));
        drag.click();

        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();

    }
}

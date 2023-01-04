package Lessons.Week02.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Homework01 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        WebElement multipleWindow = driver.findElement(By.cssSelector("a[href='/windows']"));
        multipleWindow.click();

        WebElement click= driver.findElement(By.cssSelector("a[href='/windows/new']"));
        click.click();

        Set<String> windows = driver.getWindowHandles(); //[parent id,child id]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);

        WebElement messageChild=driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
        String s=messageChild.getText();
        System.out.println(s);

        driver.switchTo().window(parentId);
        WebElement messageParent= driver.findElement(By.xpath(" //h3[contains(text(),'Opening a new window')]"));
        String s1=messageParent.getText();
        System.out.println(s1);

        driver.quit();



    }
}

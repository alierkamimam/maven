package Lessons.ThirdLesson.Section15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();

        //Switching Window
        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");

        String s = driver.findElement(By.xpath("//a[contains(text(),'Core java for Automation Testers + Interview Progr')]"))
                .getText();

        System.out.println(s);
        driver.switchTo().window(parentId);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(s);

        //Screen Shot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Users\\Ali Erkam İMAM\\Desktop\\screenshot\\logo.png"));


        //Get Height & Width
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());


        driver.quit();

    }
}

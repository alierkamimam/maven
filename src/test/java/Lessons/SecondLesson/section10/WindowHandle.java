package Lessons.SecondLesson.section10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();


        WebElement pop_up = driver.findElement(By.cssSelector(".blinkingText"));
        pop_up.click();
        Set<String> windows = driver.getWindowHandles(); //[parent id,child id]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentId);

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(emailId);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("learning");

        WebElement radioButton = driver.findElement(By.className("checkmark"));
        radioButton.click();

        WebElement terms = driver.findElement(By.id("terms"));
        terms.click();

        WebElement signButton = driver.findElement(By.id("signInBtn"));
        signButton.click();

    }
}

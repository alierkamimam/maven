package Lessons.SecondLesson.section07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.awt.windows.ThemeReader;

public class JvaAlertsPractice {
    public static void main(String[] args) throws InterruptedException {

        String name = "Erkam";
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        //Finding 'enter your name' block and click.
        WebElement enterNameBlock = driver.findElement(By.id("name"));
        enterNameBlock.sendKeys(name);

        //Finding 'Alert' Button and click.

         WebElement alertButton = driver.findElement(By.id("alertbtn"));
        alertButton.click();


        //get the message in pop-up
        System.out.println(driver.switchTo().alert().getText());

        //Click the OK Button in pop-up
        driver.switchTo().alert().accept();


/*
        //Click confirm button and then click cancel button
        WebElement alertButton = driver.findElement(By.id("confirmbtn"));
        alertButton.click()
        driver.switchTo().alert().dismiss();
*/

    }
}

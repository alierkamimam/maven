package Lessons.SecondLesson.section12;

import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class JavaScriptExecutorDemo2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");


        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

        List<WebElement> values=driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));

        int sum=0;
        for (int i = 0; i < values.size(); i++) {

            sum+=Integer.parseInt(values.get(i).getText());
            System.out.println(values.get(i).getText());
        }



    }
}

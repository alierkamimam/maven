package Lessons.Week02.section12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");


        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead  td:nth-child(4)"));
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += Integer.parseInt(values.get(i).getText());

        }
        System.out.println("Total amount Collected: " + sum);
        String sumString=sum+"";

        String totalAmount = driver.findElement(By.cssSelector(".totalAmount")).getText();
        totalAmount=totalAmount.split(":")[1].trim();

        Assert.assertEquals(totalAmount,sumString);


    }
}

package Lessons.Week02.section07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CheckBoxPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Finding Senior Citizen checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        //System.out.println(  driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        //Selected checkbox
        Assert.assertTrue( driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        //How many 'checkbox' type  are Website?
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());





    }
}

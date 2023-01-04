package Lessons.Week02.section07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PassengerDropDownPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //opening url
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Assignment to the passenger dropdown
        WebElement passengerClick = driver.findElement(By.id("divpaxinfo"));
        passengerClick.click();
        /*Thread.sleep(2000L);*/

        //Assignment to the plus(+) click  of adult
        WebElement adult = driver.findElement(By.id("hrefIncAdt"));
        //Assignment to done button
        WebElement doneButton = driver.findElement(By.id("btnclosepaxoption"));

        //How many passenger are appeared (expected 1)
        System.out.println(passengerClick.getText());

        for (int i = 0; i < 4; i++) {
            adult.click();

        }
        doneButton.click();


    }
}

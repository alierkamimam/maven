package Lessons.SecondLesson.section07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class HomeWorkUI {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        //Finding Name field and typing 'Ali Erkam Imam'
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Ali Erkam Imam");

        //Finding email field and typing 'ali@gmail.com'
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("ali@gmail.com");

        //Finding 'Check me out if you Love IceCreams!' checkbox
        WebElement exampleCheck1 = driver.findElement(By.id("exampleCheck1"));
        exampleCheck1.click();
        //Checked whether checkbox is selected
        Assert.assertTrue(exampleCheck1.isSelected());

        //Finding Gender dropdown and is selected index 1 : Female
        WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
        Select x = new Select(gender);
        x.selectByIndex(1);

        //selected gender is output given
        System.out.println("one index of gender dropdown is " + x.getFirstSelectedOption().getText());

        //we click 'Employed' radio button
        WebElement employmentStatus=driver.findElement(By.id("inlineRadio2"));
        employmentStatus.click();

        //Finding locator of calendar and then is typed  date
        WebElement calendar= driver.findElement(By.name("bday"));
        calendar.sendKeys("22.03.1997");

        //Finding submit button and click
        WebElement submitButton= driver.findElement(By.xpath("//input[@value='Submit']"));
        submitButton.click();

        //After submit button is clicked  assignment of success message is done to WebElement
        WebElement message= driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));

        // In case of the message consist of '*\n' is split
        String actualMessage=message.getText().split("\n")[1].trim();

        String expectedMessage="Success! The Form has been submitted successfully!.";

        //Checked whether actualMessage and expected message are same
        Assert.assertEquals(actualMessage,expectedMessage);
        System.out.println("Test passed");





    }
}

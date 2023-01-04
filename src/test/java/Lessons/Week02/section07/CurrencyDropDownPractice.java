package Lessons.Week02.section07;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CurrencyDropDownPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //opening url
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //dropdown with select tag-static
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        //create select objets
        Select dropdown = new Select(staticDropDown);
        //choosing 3.index = 'USA'
        dropdown.selectByIndex(3);
        // output text written in selected index
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //choosing with text
        dropdown.selectByVisibleText("AED");
        // output text written in selected text
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //choosing with value
        dropdown.selectByValue("INR");
        // output text written in selected value
        System.out.println(dropdown.getFirstSelectedOption().getText());


    }
}

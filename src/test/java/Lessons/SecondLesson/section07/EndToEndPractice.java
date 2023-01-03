package Lessons.SecondLesson.section07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class EndToEndPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement tripType = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
        tripType.click();
        WebElement fromClick = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction"));
        fromClick.click();

        WebElement from = driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='CCU']"));
        from.click();

        WebElement to = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']"));
        to.click();

        WebElement departDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[3]/a"));
        departDate.click();

        //Assignment to the passenger dropdown
        WebElement passengerClick = driver.findElement(By.id("divpaxinfo"));
        passengerClick.click();


        //Assignment to the plus(+) click  of adult
        WebElement adult = driver.findElement(By.id("hrefIncAdt"));
        //Assignment to done button
        WebElement doneButton = driver.findElement(By.id("btnclosepaxoption"));


        //Added 4 adult passenger
        for (int i = 0; i < 4; i++) {
            adult.click();
        }
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");

        doneButton.click();


        //dropdown with select tag-static
        WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //create select objets
        Select dropdown = new Select(staticDropDown);
        //choosing 3.index = 'USA'
        dropdown.selectByIndex(3);

        //Finding search button and click
        WebElement searchButton=driver.findElement(By.name("ctl00$mainContent$btn_FindFlights"));
        searchButton.click();





    }
}
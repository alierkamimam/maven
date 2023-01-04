package Lessons.SecondLesson.section11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) {
        //1-Give me the count of links on the page.
        //2-Count of footer section

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        int countOfTag = driver.findElements(By.tagName("a")).size();
        System.out.println(countOfTag);

        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //limiting webdriver scope

        int footerTagSize = footerDriver.findElements(By.tagName("a")).size();
        System.out.println(footerTagSize);

        //3-First column of footer
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int columnSize = columnDriver.findElements(By.tagName("a")).size();
        System.out.println(columnSize);

        //4- click on each link in the column and check if the pages are opening

        for (int i = 1; i < columnSize; i++) {

            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }
        //opens all the tabs
        Set<String> windowHandle = driver.getWindowHandles();
        Iterator<String> it = windowHandle.iterator();

        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }
    }
}


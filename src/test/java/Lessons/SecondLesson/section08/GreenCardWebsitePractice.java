package Lessons.SecondLesson.section08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GreenCardWebsitePractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");


        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};


        addItems(driver, itemsNeeded);

        WebElement cartButton = driver.findElement(By.xpath("//img[@alt='Cart']"));
        cartButton.click();


        WebElement checkOutButton = driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"));
        checkOutButton.click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));


        WebElement promoCode = driver.findElement(By.cssSelector("input.promoCode"));
        promoCode.sendKeys("rahulshettyacademy");

        WebElement applyButton = driver.findElement(By.cssSelector("button.promoBtn"));
        applyButton.click();


        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        WebElement messageAfterApply = driver.findElement(By.cssSelector("span.promoInfo"));
        System.out.println(messageAfterApply.getText());

    }


    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

            //Brocolli - 1 Kg

            //Brocolli,    1 kg

            String[] name = products.get(i).getText().split("-");

            String formattedName = name[0].trim();

            //format it to get actual vegetable name

            //convert array into array list for easy search

            //  check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {

                j++;

                //click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length) {

                    break;

                }
            }
        }
    }
}
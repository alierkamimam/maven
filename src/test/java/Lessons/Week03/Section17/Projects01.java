package Lessons.Week03.Section17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Projects01 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String productName = "ZARA COAT 3";

        driver.get("https://rahulshettyacademy.com/client");

        //Finding email , password , loginButton locaters
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement password = driver.findElement(By.id("userPassword"));
        WebElement loginButton = driver.findElement(By.id("login"));

        //typing email and password and then click login button
        email.sendKeys("anshika@gmail.com");
        password.sendKeys("Iamking@000");
        loginButton.click();

        //Finding products
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        //ExplicitWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));


        WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText()
                .equals(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        //waiting succeed message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        //Finding CART button and click
        WebElement cartButton = driver.findElement(By.cssSelector("[routerlink*='cart']"));
        cartButton.click();

        //Checking has the item/items been added?
        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);

        //After checking adding, Finding check Button and click
        WebElement checkOutButton = driver.findElement(By.cssSelector(".totalRow button"));
        checkOutButton.click();

        //box of country filled  with  sendkey method of Action class
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india")
                .build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

        //Finding Place Order button
        WebElement placeOrderButton = driver.findElement(By.cssSelector(".action__submit"));
        placeOrderButton.click();

        //After ordering, getting message 'THANKYOU FOR THE ORDER.'
        String message = driver.findElement(By.cssSelector(".hero-primary")).getText();
        System.out.println(message);

        Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();


    }
}

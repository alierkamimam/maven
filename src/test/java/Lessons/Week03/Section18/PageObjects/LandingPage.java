package Lessons.Week03.Section18.PageObjects;

import Lessons.Week03.Section18.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //PageFactory

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement passwordElement;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(xpath ="//div[@aria-label='Incorrect email or password.']")
    WebElement errormessage;


    public ProductCatalogue loginApplication(String email, String password) {

        userEmail.sendKeys(email);
        passwordElement.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");

    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errormessage);
        return errormessage.getText();

    }

}
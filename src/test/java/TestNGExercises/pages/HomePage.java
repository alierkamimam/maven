package TestNGExercises.pages;

import TestNGExercises.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage {

    @FindBy(css = ".navbar-nav a[href='/login']")
    private WebElement SignupLoginButton;

    @FindBy(css = ".navbar-nav a[href='/products']")
    private WebElement productButton;



    public void clickSignupLoginButton() {
        BrowserUtils.verifyElementDisplayed(SignupLoginButton);
        SignupLoginButton.click();
    }

    public void clickProductButton() {
        BrowserUtils.verifyElementDisplayed(productButton);
        productButton.click();
    }

}
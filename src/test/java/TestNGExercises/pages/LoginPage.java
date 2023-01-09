package TestNGExercises.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    //New User Signup!
    @FindBy(css = "[placeholder='Name']")
    private WebElement signupNewUserNameBox;

    @FindBy(css = "[placeholder='Email Address']:nth-child(3)")
    private WebElement signupNewUserEmailBox;

    @FindBy(css = "*[data-qa='signup-button']")
    private WebElement signupButton;

    //Login to your account
    @FindBy(css = "*[data-qa*='login-email']")
    private WebElement loginAccountEmailBox;

    @FindBy(css = "*[data-qa*='login-password']")
    private WebElement loginAccountPasswordBox;

    @FindBy(css = "*[data-qa*='login-button']")
    private WebElement loginButton;

    @FindBy(css = ".signup-form h2")
    private WebElement newUserSignupMessageWebElement;


    public void setSignupNewUserNameBox(String newUserName) {
        signupNewUserNameBox.sendKeys(newUserName);
    }

    public void setSignupNewUserEmailBox(String emailAddress) {
        signupNewUserEmailBox.sendKeys(emailAddress);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public void setLoginAccountEmailBox(String loginEmail) {
        loginAccountEmailBox.sendKeys(loginEmail);
    }

    public void setLoginAccountPasswordBox(String loginPassword) {
        loginAccountPasswordBox.sendKeys(loginPassword);
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public String getNewUserSignupMessage() {
        return  newUserSignupMessageWebElement.getText();

    }


}

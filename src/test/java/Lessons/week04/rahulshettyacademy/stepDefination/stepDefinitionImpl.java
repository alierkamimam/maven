package Lessons.week04.rahulshettyacademy.stepDefination;


import TestNGExercises.automationexercise.BaseTest;
import TestNGExercises.utilities.BrowserUtils;
import TestNGExercises.utilities.ConfigurationReader;
import TestNGExercises.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class stepDefinitionImpl extends BaseTest {
    public SoftAssert softAssert = new SoftAssert();

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");

        Driver.getDriver().get(URL);
        System.out.println(":::::: Test Information ::::::\n\tURL :\"" + URL + "\"\n\tBrowser :\"" + browser + "\"\n\tEnvironment :" + environment);
        BrowserUtils.wait(1);
        //Launch browser and Navigate to url 'http://automationexercise.com'
        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();
        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();

        //Verify 'New User Signup!' is visible
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");


    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String username, String email) {
        pages.getLoginPage().setSignupNewUserNameBox(username);
        pages.getLoginPage().setSignupNewUserEmailBox(email);
        pages.getLoginPage().clickSignupButton();

        String actualEnterAccountInformationTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle, "ENTER ACCOUNT INFORMATION", "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\\n");


    }

    @When("^I fill password (.+) and birthday (.+) and (.+) and (.+)$")
    public void I_fill_password_and_birthday(String password, String day, String month, String year)  {
        pages.getSignupPage().selectTitleWomen();
        pages.getSignupPage().setPassword(password);
        pages.getSignupPage().setDateOfBirth(day, month, year);


    }

    @And("Switch to productPage with product button")
    public void Switch_to_productPage_with_product_button() {
        pages.getSignupPage().selectProductsPageButton();
        pages.getProductsPage().searchProduct("Fancy Green Top");
        BrowserUtils.wait(6);
        softAssert.assertAll();
    }

    @Then("Close to window")
    public void Close_to_window() {
        Driver.getDriver().quit();
    }

}

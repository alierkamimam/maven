package TestNGExercises.automationexercise;

import TestNGExercises.utilities.BrowserUtils;
import TestNGExercises.utilities.ConfigurationReader;
import TestNGExercises.utilities.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert(); // We should use soft assertion because in this test case we have multiple cases to test

    @BeforeSuite
    public void setUpSuite() {
        // code that is executed before the entire test suite
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");

        Driver.getDriver().get(URL);
        System.out.println(":::::: Test Information ::::::\n\tURL :\"" + URL + "\"\n\tBrowser :\"" + browser + "\"\n\tEnvironment :"+environment);
        BrowserUtils.wait(1);


    }

    @Test(priority = 0)
    public void Test_1_Register_User() {

        //Launch browser and Navigate to url 'http://automationexercise.com'
        //Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();
        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();

        //Verify 'New User Signup!' is visible
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");

        pages.getLoginPage().setSignupNewUserNameBox("ali erkam");
        pages.getLoginPage().setSignupNewUserEmailBox("erkam@mail.com");
        pages.getLoginPage().clickSignupButton();

        String actualEnterAccountInformationTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle, "ENTER ACCOUNT INFORMATION", "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\\n");


        pages.getSignupPage().selectTitleWomen();
        pages.getSignupPage().setPassword("12345");
        pages.getSignupPage().setDateOfBirth("12", "April", "1945");

        pages.getSignupPage().selectProductsPageButton();
        pages.getProductsPage().searchProduct("Fancy Green Top");

        BrowserUtils.wait(6);

        softAssert.assertAll();
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }


}




package Lessons.Week03.Section19.Test;

import Lessons.Week03.Section19.TestComponents.BaseTest;
import Lessons.Week03.Section18.PageObjects.CartPage;
import Lessons.Week03.Section18.PageObjects.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation() {
        String productName = "ZARA COAT 3";
        landingPage.loginApplication("anshika@gmail.com", "inadia");
        AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }


    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match =cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);

    }


}

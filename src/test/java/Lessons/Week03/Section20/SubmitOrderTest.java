package Lessons.Week03.Section20;

import Lessons.Week03.Section18.PageObjects.CartPage;
import Lessons.Week03.Section18.PageObjects.ConfirmationPage;
import Lessons.Week03.Section18.PageObjects.OrderPage;
import Lessons.Week03.Section18.PageObjects.ProductCatalogue;
import Lessons.Week03.Section19.TestComponents.BaseTest;
import Lessons.Week03.Section20.rahulshetty.data.DataReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = "Purchase")
    public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = productCatalogue.getProductList();

        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();


        Boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        Lessons.Week03.Section18.PageObjects.CheckOutPage checkOutPage = cartPage.goToCheckOut();
        checkOutPage.selectCountry("india");

        ConfirmationPage confirmationPage = checkOutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }

    @Test(dependsOnMethods = {"SubmitOrder"})
    public void OrderHistoryTest() {
        //"ZARA COAT 3"
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
        OrderPage orderPage = productCatalogue.goToOrderPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {


        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\Lessons\\Week03\\Section20\\rahulshetty\\data\\PurchaseOrder.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};

    }
}

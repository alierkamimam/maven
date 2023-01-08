package Lessons.Week03.Section19.Test;

import Lessons.Week03.Section18.PageObjects.CartPage;
import Lessons.Week03.Section18.PageObjects.ConfirmationPage;
import Lessons.Week03.Section18.PageObjects.OrderPage;
import Lessons.Week03.Section18.PageObjects.ProductCatalogue;
import Lessons.Week03.Section19.TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class FrameWorkExercises_rahulshettycom extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData",groups = "Purchase")
    public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
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
      /*  HashMap<String, String> map = new HashMap<>();
        map.put("email", "anshika@gmail.com");
        map.put("password", "Iamking@000");
        map.put("product", "ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "shetty@gmail.com");
        map1.put("password", "Iamking@000");
        map1.put("product", "ADIDAS ORIGINAL");*/

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\Lessons\\Week03\\Section20\\rahulshetty\\data\\PurchaseOrder.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};

       // return new Object[][]{{map1},{map}};
    }
}
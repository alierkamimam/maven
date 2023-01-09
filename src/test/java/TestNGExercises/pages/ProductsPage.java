package TestNGExercises.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{


    @FindBy(id = "search_product")
    private WebElement searchProductBox;


    public void searchProduct(String productName){
        searchProductBox.sendKeys(productName);
    }
}

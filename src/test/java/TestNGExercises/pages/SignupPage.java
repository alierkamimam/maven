package TestNGExercises.pages;

import TestNGExercises.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class SignupPage extends BasePage {

    //Fill details: Title, Name, Email, Password, Date of birth
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2/b")
    private WebElement enterAccountInformationTitle;

    @FindBy(id = "id_gender1")
    private WebElement id_genderMen;

    @FindBy(id = "id_gender2")
    private WebElement id_genderWomen;

    @FindBy(id = "first_name")
    private WebElement FirstNameBox;

    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "days")
    private WebElement dateOfBirth_DAYs;

    @FindBy(id = "months")
    private WebElement dateOfBirth_MONTHs;

    @FindBy(id = "years")
    private WebElement dateOfBirth_YEARs;

    @FindBy(css = "a[href='/products']")
    private WebElement productsPageButton;


    public SignupPage() {

    }

    public String getEnterAccountInformationTitle() {
        return enterAccountInformationTitle.getText();
    }

    public void selectTitleMen() {
        id_genderMen.click();
    }

    public void selectTitleWomen() {
        id_genderWomen.click();
    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void setDateOfBirth(String day, String month, String year) {
        setDay(day);
        setMonth(month);
        setYear(year);

    }

    private void setYear(String year) {
        Select select = new Select(dateOfBirth_YEARs);
        select.selectByVisibleText(year);

    }

    private void setMonth(String month) {
        Select select = new Select(dateOfBirth_MONTHs);
        select.selectByVisibleText(month);


    }

    private void setDay(String day) {
        Select select = new Select(dateOfBirth_DAYs);
        select.selectByVisibleText(day);


    }

    public void selectProductsPageButton() {
        productsPageButton.click();
    }


}

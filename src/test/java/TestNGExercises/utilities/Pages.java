package TestNGExercises.utilities;


import TestNGExercises.pages.HomePage;
import TestNGExercises.pages.SignupPage;
import TestNGExercises.pages.ProductsPage;
import TestNGExercises.pages.LoginPage;

public class Pages {
    private HomePage homePage;
    private SignupPage signupPage;
    private LoginPage loginPage;

    private ProductsPage productsPage;


    public Pages() {
        this.homePage = new HomePage();
        this.signupPage = new SignupPage();
        this.loginPage = new LoginPage();
        this.productsPage = new ProductsPage();
    }

    public SignupPage getSignupPage() {

        return signupPage;
    }


    public HomePage getHomePage() {

        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProductsPage getProductsPage() {
        return productsPage;
    }
}
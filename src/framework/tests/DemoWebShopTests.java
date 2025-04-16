package framework.tests;

import framework.base.BaseTest;
import framework.pages.CartPage;
import framework.pages.LoginPage;
import framework.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoWebShopTests extends BaseTest {

    // Shared variable to hold the dynamically generated email
    private String registeredEmail;

    @Test(priority = 1)
    public void registerUserTest() {
        test = extentReports.createTest("User Registration Test");

        navigateTo("https://demowebshop.tricentis.com/register");

        // Generate a unique email
        registeredEmail = "john.doe" + System.currentTimeMillis() + "@example.com";

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("John", "Doe", registeredEmail, "Password123");

        Assert.assertTrue(registerPage.isUserLoggedIn(), "User not logged in after registration!");

        test.pass("User registration and post-registration login validated successfully with email: " + registeredEmail);
    }

    @Test(priority = 2, dependsOnMethods = "registerUserTest")
    public void addItemToCartTest() {
        test = extentReports.createTest("Add Item to Cart Test");

        navigateTo("https://demowebshop.tricentis.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(registeredEmail, "Password123");

        Assert.assertTrue(loginPage.isUserLoggedIn(), "Login failed!");

        CartPage cartPage = new CartPage(driver);
        cartPage.searchAndAddToCart("Jeans");
        cartPage.searchAndAddToCart("Laptop");
        cartPage.searchAndAddToCart("Book");

       Assert.assertTrue(cartPage.isItemInCart("Jeans"), "Jeans not added to cart!");
        Assert.assertTrue(cartPage.isItemInCart("Laptop"), "Laptop not added to cart!");
        Assert.assertTrue(cartPage.isItemInCart("Book"), " Book not added to cart!");

        test.pass("Items added to cart successfully.");
    }
}

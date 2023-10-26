package pl.seleniumdemo.tests;

import org.testng.annotations.Test;
import pl.seleniumdemo.Model.Customer;
import pl.seleniumdemo.pages.*;

public class ShopTest extends BaseTest{

    @Test
    public void buyProductFromListTest() throws InterruptedException {
        Customer customer = new Customer("Mike", "Mike", "Poland", "Warsaw", "30-300",
                "Warsaw", "999999999", "Mike@gmail.com");

        HomePage homePage = new HomePage(driver);
        homePage.openShopPage();

        ShopPage shopPage = new ShopPage(driver);
        shopPage.addProductToCart("Java Selenium WebDriver");

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        productPage.openCartPage();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        FormFillingPage formFillingPage = new FormFillingPage(driver);
        formFillingPage.fillFormAndPlaceOrder(customer);
    }
}

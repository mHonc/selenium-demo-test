package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.seleniumdemo.Model.Customer;
import pl.seleniumdemo.pages.*;
import pl.seleniumdemo.utils.ExcelReader;
import pl.seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;

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

        ConfirmedOrderPage confirmedOrderPage = new ConfirmedOrderPage(driver);
        SeleniumHelper.waitForElementToBeVisible(driver, confirmedOrderPage.getOrderConfirmationTextField());
        Assert.assertEquals(confirmedOrderPage.getOrderConfirmationTextField().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(confirmedOrderPage.getProductName().getText(), "Java Selenium WebDriver × 1");
    }

    @Test(dataProvider = "getData")
    public void buyProductFromListTestWithDataProvider(String firstName, String lastName, String country,
                                                       String adress1, String postCode, String city, String phone, String email) throws InterruptedException {
        Customer customer = new Customer(firstName, lastName, country, adress1, postCode, city, phone, email);

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

        ConfirmedOrderPage confirmedOrderPage = new ConfirmedOrderPage(driver);
        SeleniumHelper.waitForElementToBeVisible(driver, confirmedOrderPage.getOrderConfirmationTextField());
        Assert.assertEquals(confirmedOrderPage.getOrderConfirmationTextField().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(confirmedOrderPage.getProductName().getText(), "Java Selenium WebDriver × 1");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return ExcelReader.readExcel("TestData.xlsx");
    }
}

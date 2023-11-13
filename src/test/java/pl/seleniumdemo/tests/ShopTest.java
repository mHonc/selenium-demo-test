package pl.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
    public void buyProductFromListTest() throws InterruptedException, IOException {
        ExtentTest test = extentReports.createTest("Buy product test");
        Customer customer = new Customer("Mike", "Mike", "Poland", "Warsaw", "30-300",
                "Warsaw", "999999999", "Mike@gmail.com");

        HomePage homePage = new HomePage(driver);
        homePage.openShopPage();
        test.log(Status.PASS, "Opened shop page");

        ShopPage shopPage = new ShopPage(driver);
        shopPage.addProductToCart("Java Selenium WebDriver");

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        test.log(Status.PASS, "Product added to cart");
        productPage.openCartPage();
        test.log(Status.PASS, "Opened cart page");

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        FormFillingPage formFillingPage = new FormFillingPage(driver);
        formFillingPage.fillFormAndPlaceOrder(customer);
        test.log(Status.PASS, "Filled order form");

        ConfirmedOrderPage confirmedOrderPage = new ConfirmedOrderPage(driver);
        SeleniumHelper.waitForElementToBeVisible(driver, confirmedOrderPage.getOrderConfirmationTextField());
        Assert.assertEquals(confirmedOrderPage.getOrderConfirmationTextField().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(confirmedOrderPage.getProductName().getText(), "Java Selenium WebDriver × 1");
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test(dataProvider = "getData")
    public void buyProductFromListTestWithDataProvider(String firstName, String lastName, String country,
                                                       String adress1, String postCode, String city, String phone, String email) throws InterruptedException, IOException {
        ExtentTest test = extentReports.createTest("Buy product test with data provider");
        Customer customer = new Customer(firstName, lastName, country, adress1, postCode, city, phone, email);

        HomePage homePage = new HomePage(driver);
        homePage.openShopPage();
        test.log(Status.PASS, "Opened shop page");

        ShopPage shopPage = new ShopPage(driver);
        shopPage.addProductToCart("Java Selenium WebDriver");

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        test.log(Status.PASS, "Product added to cart");
        productPage.openCartPage();
        test.log(Status.PASS, "Opened cart page");

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        FormFillingPage formFillingPage = new FormFillingPage(driver);
        formFillingPage.fillFormAndPlaceOrder(customer);
        test.log(Status.PASS, "Filled order form");

        ConfirmedOrderPage confirmedOrderPage = new ConfirmedOrderPage(driver);
        SeleniumHelper.waitForElementToBeVisible(driver, confirmedOrderPage.getOrderConfirmationTextField());
        Assert.assertEquals(confirmedOrderPage.getOrderConfirmationTextField().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(confirmedOrderPage.getProductName().getText(), "Java Selenium WebDriver × 1");
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return ExcelReader.readExcel("TestData.xlsx");
    }
}

package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.MyAccountPage;

import java.util.Random;

public class CreateAccountTest extends BaseTest {

    @Test
    public void registerTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();

        int min = 100_000_000;
        int max = 999_999_999;
        Random random = new Random();
        String randomNineDigitNumber = String.valueOf(random.nextInt(max - min + 1) + min);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.register(randomNineDigitNumber + "@gmail.com", randomNineDigitNumber);
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertEquals(loggedUserPage.getUserIdText().getText(), randomNineDigitNumber);
    }

    @Test
    public void registerRegisteredUserTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();
        //assuming this user already exists
        //everyday database is reset
        String username = "bap123";
        String password = "Bap123456789%";

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.register(username + "@gmail.com", password);
        Assert.assertTrue(myAccountPage.getRegisterError().isDisplayed());
    }
}

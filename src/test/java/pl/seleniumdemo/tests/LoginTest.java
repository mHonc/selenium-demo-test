package pl.seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.MyAccountPage;
import pl.seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;
import java.util.Random;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws IOException {
        ExtentTest test = extentReports.createTest("Existing user logging test");
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();
        test.log(Status.PASS, "Opened my account page");
        //assuming this user already exists
        //everyday database is reset
        String username = "bap123";
        String password = "Bap123456789%";

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.login(username + "@gmail.com", password);
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertEquals(loggedUserPage.getUserIdText().getText(), username);
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }

    @Test
    public void loginWithUnregisteredUserTest() throws IOException {
        ExtentTest test = extentReports.createTest("Unregistered user logging test");
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();
        test.log(Status.PASS, "Opened my account page");

        int min = 100_000_000;
        int max = 999_999_999;
        Random random = new Random();
        String randomNineDigitNumber = String.valueOf(random.nextInt(max - min + 1) + min);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.login(randomNineDigitNumber + "@gmail.com", randomNineDigitNumber);
        Assert.assertTrue(myAccountPage.getLoginNoSuchUserError().isDisplayed());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }
}

package pl.seleniumdemo.tests;

import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.pages.MyAccountPage;

public class CreateAccountTest extends BaseTest{

    @Test
    public void signUpTest(){
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();

        MyAccountPage myAccountPage = new MyAccountPage(driver);

    }
}

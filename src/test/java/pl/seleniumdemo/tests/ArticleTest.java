package pl.seleniumdemo.tests;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.ArticlePage;
import pl.seleniumdemo.pages.HomePage;
import pl.seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;

public class ArticleTest extends BaseTest{
    @Test
    public void openArticleTest() throws IOException {
        ExtentTest test = extentReports.createTest("Open article test");
        String articleToFind = "Hello World";
        HomePage homePage = new HomePage(driver);
        homePage.openArticlePage(articleToFind);
        ArticlePage articlePage = new ArticlePage(driver);
        Assert.assertEquals(articleToFind, articlePage.getArticleTitle().getText());
        test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
    }
}

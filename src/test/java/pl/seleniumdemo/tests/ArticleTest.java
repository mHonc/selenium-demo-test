package pl.seleniumdemo.tests;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.ArticlePage;
import pl.seleniumdemo.pages.HomePage;

public class ArticleTest extends BaseTest{
    @Test
    public void openArticleTest() {
        String articleToFind = "Hello World";
        HomePage homePage = new HomePage(driver);
        homePage.openArticlePage(articleToFind);
        ArticlePage articlePage = new ArticlePage(driver);
        Assert.assertEquals(articleToFind, articlePage.getArticleTitle().getText());
    }
}

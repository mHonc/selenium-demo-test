package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage {

    @FindBy(xpath = "//h1[@class='entry-title']")
    private WebElement articleTitle;

    public ArticlePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getArticleTitle() {
        return articleTitle;
    }
}

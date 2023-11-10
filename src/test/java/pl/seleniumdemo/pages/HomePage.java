package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//a/span[text()='My account']")
    private WebElement myAccountButton;

    @FindBy(id = "menu-item-21")
    private WebElement shopButton;

    @FindBy(xpath = "//a[@class='czr-title']")
    List<WebElement> articles;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openMyAccountPage() {
        myAccountButton.click();
    }

    public void openShopPage() {
        shopButton.click();
    }

    public void openArticlePage(String articleName){
        for(WebElement article : articles){
            if(article.getText().equals(articleName))
                article.click();
        }
    }
}

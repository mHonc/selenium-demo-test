package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//a/span[text()='My account']")
    private WebElement myAccountButton;

    @FindBy(id = "menu-item-21")
    private WebElement shopButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openMyAccountPage() {
        myAccountButton.click();
    }

    public void openShopPage() {
        shopButton.click();
    }
}

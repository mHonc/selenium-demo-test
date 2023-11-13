package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {
    @FindBy(xpath = "//div/p/strong")
    private WebElement userIdText;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserIdText() {
        return userIdText;
    }
}

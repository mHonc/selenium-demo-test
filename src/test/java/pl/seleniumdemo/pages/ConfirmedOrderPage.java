package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmedOrderPage {

    @FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")
    private WebElement orderConfirmationText;

    public ConfirmedOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getOrderConfirmationText(){
        return orderConfirmationText;
    }
}

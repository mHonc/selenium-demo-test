package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmedOrderPage {

    @FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")
    private WebElement orderConfirmationTextField;

    @FindBy(xpath = "//td[contains(@class, 'product-name')]")
    private WebElement productName;

    public ConfirmedOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getOrderConfirmationTextField(){
        return orderConfirmationTextField;
    }

    public WebElement getProductName() { return productName; }
}

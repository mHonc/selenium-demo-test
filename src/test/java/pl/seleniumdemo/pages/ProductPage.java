package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div/a[@class='button wc-forward' and text()='View cart']")
    private WebElement openCartButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(){
        addToCartButton.click();
    }

    public void openCartPage(){
        openCartButton.click();
    }
}

package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPage {

    @FindBy(xpath = "//ul[@class='products columns-4']/li/a/h2")
    List<WebElement> products;

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getProduct(int n) {
        return products.get(n);
    }

    public void addProductToCart(String productName) {
        for (WebElement product : products) {
            if (product.getText().equals(productName)) {
                product.click();
            }
        }
    }

}

package pl.seleniumdemo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.seleniumdemo.Model.Customer;

public class FormFillingPage {
    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement companyInput;

    @FindBy(id = "select2-billing_country-container")
    private WebElement countryContainer;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement countryInput;

    @FindBy(id = "billing_address_1")
    private WebElement adressInput1;

    @FindBy(id = "billing_address_2")
    private WebElement adressInput2;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeInput;

    @FindBy(id = "billing_city")
    private WebElement cityInput;

    @FindBy(id = "billing_phone")
    private WebElement phoneInput;

    @FindBy(id = "billing_email")
    private WebElement emailInput;

    @FindBy(id = "order_comments")
    private WebElement notesInput;

    @FindBy(xpath = "//button[@id='place_order']")
    private WebElement placeOrderButton;

    public FormFillingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void fillFormAndPlaceOrder(Customer customer) throws InterruptedException {
        this.firstNameInput.sendKeys(customer.getFirstName());
        this.lastNameInput.sendKeys(customer.getLastName());
        this.countryContainer.click();
        this.countryInput.sendKeys(customer.getCountry());
        this.countryInput.sendKeys(Keys.ENTER);
        this.adressInput1.sendKeys(customer.getAdress1());
        this.postcodeInput.sendKeys(customer.getPostcode());
        this.cityInput.sendKeys(customer.getCity());
        this.phoneInput.sendKeys(customer.getPhone());
        this.emailInput.sendKeys(customer.getEmail());
        this.companyInput.sendKeys(customer.getCompanyName());
        this.adressInput2.sendKeys(customer.getAdress2());
        this.notesInput.sendKeys(customer.getComments());
        Thread.sleep(1000);
        this.placeOrderButton.click();
    }
}

package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(id = "reg_email")
    private WebElement registrationEmailInput;

    @FindBy(id = "reg_password")
    private WebElement registrationPasswordInput;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(id = "username")
    private WebElement loginEmailInput;

    @FindBy(id = "password")
    private WebElement loginPasswordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//strong[text()= 'Error:']")
    private WebElement registerError;

    @FindBy(xpath = "//strong[text()= 'ERROR']")
    private WebElement loginNoSuchUserError;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegisterError() {
        return registerError;
    }

    public WebElement getLoginNoSuchUserError() {
        return loginNoSuchUserError;
    }

    public void register(String email, String password) {
        registrationEmailInput.sendKeys(email);
        registrationPasswordInput.sendKeys(password);
        registerButton.click();
    }

    public void login(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
    }
}

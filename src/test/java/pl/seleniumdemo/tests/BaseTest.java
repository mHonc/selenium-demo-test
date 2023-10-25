package pl.seleniumdemo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.seleniumdemo.utils.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

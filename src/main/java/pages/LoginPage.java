package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    /*-----------  Constructor  -----------*/
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /*-----------  Locators  -----------*/
    By userNameLocator =  By.cssSelector("input[name='username']");
    By passwordLocator = By.cssSelector("input[name='password']");
    By loginLocator = By.cssSelector("button[type='submit']");

    /*-----------  Actions  -----------*/
    public void login(String username, String password) {
        System.out.println("Logging in with username: " + username + " and password: " + password);
        WebElement userNameField = waitUtils.waitForVisibility(userNameLocator);
        elementActions.enterTextInField(userNameField, username);

        WebElement passwordField = waitUtils.waitForVisibility(passwordLocator);
        elementActions.enterTextInField(passwordField, password);

        WebElement loginButton = waitUtils.waitForVisibility(loginLocator);
        elementActions.clickElement(loginButton);
    }
}
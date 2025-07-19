package pages.components;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Toast extends BasePage {

    /*-----------  Constructor  -----------*/
    public Toast(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /*-----------  Locators  -----------*/
    private static final String bottomToastLocator = "div.oxd-toast-container.oxd-toast-container--bottom";

    /*-----------  Actions  -----------*/
    public WebElement getBottomToast() {
        System.out.println("Getting bottom toast element");
        By locator = By.cssSelector(bottomToastLocator);
        return waitUtils.waitForVisibility(locator);
    }
}

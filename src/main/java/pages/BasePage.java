package pages;
import org.openqa.selenium.*;
import utils.ElementActions;
import utils.WaitUtils;

public class BasePage {
    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected ElementActions elementActions;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.elementActions = new ElementActions(driver);
    }
}
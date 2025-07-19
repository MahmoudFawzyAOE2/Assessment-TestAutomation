package pages.components;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenu extends BasePage {

    /*-----------  Constructor  -----------*/
    public SideMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /*-----------  Locators  -----------*/
    private static final String menuItemSelector = "ul.oxd-main-menu li:nth-of-type(%d) a";

    /*-----------  Actions  -----------*/
    public void navigateToPage(int menuIndex) {
        String pageSelector = String.format(menuItemSelector, menuIndex + 1); // Convert 0-based to 1-based
        By pageLocator = By.cssSelector(pageSelector);

        elementActions.clickElement(driver.findElement(pageLocator));
    }
}

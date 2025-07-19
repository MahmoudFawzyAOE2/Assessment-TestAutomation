package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class ElementActions {

    private final WebDriver driver;
    private WaitUtils waitUtils;


    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);

    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }
    public void hoverElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
    public void enterTextInField(WebElement field, String text) {
        System.out.println("Entering text in field: " + field + " with text: " + text);
        scrollToElement(field);
        field.clear();
        field.sendKeys(text);
    }
    public void selectFromMenu(WebElement dropdown, String option) {
        System.out.println("Selecting option: " + option + " from dropdown: " + dropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }
    public void clickElement(WebElement element) {
        scrollToElement(element);
        try {
            System.out.println("Clicking element: " + element);
            // Wait for visibility first
            waitUtils.waitForVisibility(element);

            // Wait for clickability
            waitUtils.waitToBeClickable(element);

            // Try normal click
            element.click();
        } catch (ElementClickInterceptedException intercepted) {
            System.out.println("Element click intercepted. Retrying with JS click: " + element);

            // Fallback: JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (TimeoutException e) {
            System.out.println("Element not clickable within timeout: " + element);
            throw e;
        } catch (Exception e) {
            System.out.println("Exception occurred while clicking element: " + element);
            throw e;
        }
    }
    public String getTextFromElement(WebElement element) {

        waitUtils.waitForVisibility(element);
        String text = element.getText().trim();
        System.out.println("Retrieved text: \"" + text + "\"");
        return text;
    }
}
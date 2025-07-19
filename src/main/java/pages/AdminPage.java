package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage extends BasePage {

    /*-----------  Constructor  -----------*/
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    /*-----------  Locators  -----------*/
    By formLocator = By.cssSelector(".oxd-form-row");
    By userNameFieldLocator = By.cssSelector("input.oxd-input");
    By tableRecordLocator = By.cssSelector(".oxd-table-card");
    By searchResultDataRelativeLocator = By.cssSelector("div.oxd-table-cell.oxd-padding-cell");
    By searchResultDeleteIconRelativeLocator = By.cssSelector(".bi-trash");
    By searchResultDeleteButtonRelativeLocator = By.xpath("./ancestor::button");

    /*-----------  Actions  -----------*/
    public void searchForUser(String username) {
        System.out.println("Searching for user: " + username);
        WebElement formElement = waitUtils.waitForVisibility(formLocator);
        elementActions.scrollToElement(formElement);

        WebElement userNameFieldElement = formElement.findElement(userNameFieldLocator);
        elementActions.enterTextInField(userNameFieldElement, username);

        userNameFieldElement.sendKeys(Keys.ENTER);
    }

    public int getSearchResultsCount() {
        System.out.println("Getting search results count");
        WebElement ableRecordElement = waitUtils.waitForVisibility(tableRecordLocator);
        elementActions.scrollToElement(ableRecordElement);
        return driver.findElements(tableRecordLocator).size();
    }

    public WebElement getSearchResultByIndex(int index) {
        System.out.println("Getting search result at index: " + index);
        waitUtils.waitForVisibility(tableRecordLocator);
        return driver.findElements(tableRecordLocator).get(index);
    }

    public List<String> getSearchResultDataByIndex(int index) {
        System.out.println("Getting search result data at index: " + index);
        WebElement resultElement = getSearchResultByIndex(index);
        List<WebElement> cells = resultElement.findElements(searchResultDataRelativeLocator);

        String userName = cells.get(1).getText();
        String userRole = cells.get(2).getText();
        String status = cells.get(4).getText();

        return List.of(userRole, userName, status);
    }

    public void deleteSearchResultByIndex(int index) {
        System.out.println("Deleting search result at index: " + index);
        WebElement resultElement = getSearchResultByIndex(index);
        WebElement deleteIcon = resultElement.findElement(searchResultDeleteIconRelativeLocator);
        WebElement deleteButton = deleteIcon.findElement(searchResultDeleteButtonRelativeLocator);
        elementActions.clickElement(deleteButton);
    }
}

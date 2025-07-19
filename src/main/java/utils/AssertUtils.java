package utils;

import com.google.common.base.Supplier;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AssertUtils {

    /*-----------  Constructor  -----------*/
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final ElementActions elementActions ;


    public AssertUtils(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.elementActions = new ElementActions(driver);
    }

    /*-----------  Actions  -----------*/

    public void assertEquals(WebElement element, String expectedText) {
        String actualText = elementActions.getTextFromElement(element);
        Assert.assertEquals(actualText, expectedText,
                "Text mismatch! Expected: \"" + expectedText + "\", but got: \"" + actualText + "\"");
    }

    public void assertSearchResultsCount(Supplier<Integer> countSupplier, int expectedCount) {
        waitUtils.wait.until(driver -> countSupplier.get() == expectedCount);
        Assert.assertEquals(countSupplier.get(), expectedCount);
    }

    public void assertEquals(List<String> actualList, List<String> expectedList) {
        Assert.assertEquals(actualList.size(), expectedList.size(),
                "List sizes do not match!\nExpected size: " + expectedList.size() + ", Actual size: " + actualList.size());

        for (int i = 0; i < expectedList.size(); i++) {
            String expected = expectedList.get(i);
            String actual = actualList.get(i);

            Assert.assertEquals(actual, expected,
                    "Mismatch at index " + i + ":\nExpected: \"" + expected + "\"\nActual:   \"" + actual + "\"");
        }
    }
    public void assertTextContains(WebElement element, String expectedSubstring) {
        String actualText = elementActions.getTextFromElement(element);
        Assert.assertTrue(actualText.contains(expectedSubstring),
                "Expected text to contain: \"" + expectedSubstring + "\", but got: \"" + actualText + "\"");
    }
    public void assertURLMatches(String expectedURL) {
        System.out.println("Asserting URL matches: " + expectedURL);

        boolean matched = waitUtils.waitForURLToBe(expectedURL);

        if (!matched) {
            String actualURL = driver.getCurrentUrl();
            Assert.fail("URL did not match within timeout.\nExpected: \"" + expectedURL + "\"\nActual:   \"" + actualURL + "\"");
        }
    }

    public void assertElementIsVisible(WebElement element) {
        try {
            if (element.isDisplayed()) {
                System.out.println("Element is visible: " + element);
            } else {
                Assert.fail("Element is present but not visible: " + element);
            }
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            Assert.fail("Element is not visible or no longer attached to the DOM: " + element, e);
        }
    }

}
package tests.ui;

import drivers.DriverManager;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import listeners.CustomListener;

@Listeners(CustomListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverManager.getDriver();
    }

    @AfterClass
    public void tearDown(ITestContext context) {
        if (CustomListener.testFailed) {
            System.out.println("Test failed. Keeping browser open for debugging.");
            return;
        }
        DriverManager.quitDriver();
    }
}

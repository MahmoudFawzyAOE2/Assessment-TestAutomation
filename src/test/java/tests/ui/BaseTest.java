package tests.ui;

import drivers.DriverManager;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import listeners.CustomListener;

import java.awt.*;
import java.io.File;
import java.io.IOException;

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
        } else {
            DriverManager.quitDriver();
        }
    }

    @AfterSuite
    public void openReport() {
        try {
            File htmlFile = new File("test-output/html/index.html");
            if (htmlFile.exists()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Report not found: test-output/html/index.html");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

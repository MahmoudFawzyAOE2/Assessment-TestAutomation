package tests.ui;

import listeners.CustomListener;
import pages.*;
import pages.components.*;
import utils.AssertUtils;
import testData.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)

public class AdminTests extends BaseTest {
    private LoginPage loginPage;
    private AdminPage adminPage;
    private SideMenu sideMenu;
    private Toast toast ;
    private AssertUtils assertUtils ;

    @BeforeMethod
    public void setUp() {
        // Connect WebDriver from Test with WebDriver from Page
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        sideMenu = new SideMenu(driver);
        toast = new Toast(driver);
        assertUtils = new AssertUtils(driver);
    }

    @Test(priority = 1)
    public void AdminAssertions() {

        // 1- Go to the main page
        driver.get(URLs.BASE_URL);

        // 2- Login using Admin Credentials
        loginPage.login(TestData.AdminUserName, TestData.AdminPassword);
        assertUtils.assertURLMatches(URLs.DASHBOARD_URL);

        // 3- Click the Admin tab on the left sidebar
        sideMenu.navigateToPage(TestData.AdminPageIndex);
        assertUtils.assertURLMatches(URLs.ADMIN_URL);

        // 4- Search using the username for the admin user
        adminPage.searchForUser(TestData.AdminUserName);


        // 5- Assert that the number of results, the username, the user role, and the status are correct
        assertUtils.assertSearchResultsCount(() -> adminPage.getSearchResultsCount(), TestData.NumberOfAdmins);
        assertUtils.assertEquals(adminPage.getSearchResultDataByIndex(0),TestData.AdminData);

        // 6- Click the Delete icon (trash bin) on the table
        adminPage.deleteSearchResultByIndex(0);

        // 7- Assert that the admin user deletion is not allowed (either nothing happens, or an error appears)
        assertUtils.assertElementIsVisible(adminPage.getSearchResultByIndex(0));
        assertUtils.assertElementIsVisible(toast.getBottomToast());
    }
}
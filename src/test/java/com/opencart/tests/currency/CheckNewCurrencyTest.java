package com.opencart.tests.currency;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AdminCurrencyPageBL;
import com.opencart.steps.AdminDashboardBL;
import com.opencart.steps.AdminLoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.*;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;
import static com.opencart.enums.URLs.BASE_URL;

public class CheckNewCurrencyTest extends BaseTest {
    private final String newCurrencyName = "UAH";
    private final String newCurrencyValue = "28.22";

    @Description("Test sets new currency with newCurrencyName, newCurrencyValue through admin page")
    @BeforeMethod (alwaysRun = true)
    public void setNewCurrencyTest() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Currencies");
        new AdminCurrencyPageBL()
                .clickOnAddNewCurrencyButton()
                .addNewCurrency(newCurrencyName, newCurrencyValue);
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Test (description = "Test checks if the cost of all products on the website's main page is correct " +
            "for new currencies that was set through admin page")
    public void checkNewCurrencyTest() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL
                .getHeaderPageBL()
                .clickOnChangeCurrencyButton()
                .clickOnCurrencyButton(newCurrencyName);
        mainPageBL.verifyAllProductsPrices(newCurrencyName, newCurrencyValue);
    }

    @Description("Test deletes new currency with newCurrencyName, newCurrencyValue through admin page")
    @AfterMethod(alwaysRun = true)
    public void deleteNewCurrencyTest() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Currencies");
        new AdminCurrencyPageBL()
                .deleteCurrency(newCurrencyName)
                .verifySuccessCurrencyEdit();
    }
}
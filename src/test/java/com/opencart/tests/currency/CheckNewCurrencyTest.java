package com.opencart.tests.currency;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AdminCurrencyPageBL;
import com.opencart.steps.AdminDashboardBL;
import com.opencart.steps.AdminLoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.*;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;
import static com.opencart.enums.URLs.BASE_URL;

public class CheckNewCurrencyTest extends BaseTest {
    private final String newCurrencyName = "UAH";
    private final String newCurrencyValue = "28.22";

    @BeforeMethod
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

    @Test
    public void checkNewCurrencyTest() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL
                .getHeaderPageBL()
                .clickOnChangeCurrencyButton()
                .clickOnCurrencyButton(newCurrencyName);
        mainPageBL.verifyAllProductsPrices(newCurrencyName, newCurrencyValue);
    }

    @AfterMethod
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
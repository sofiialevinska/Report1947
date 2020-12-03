package com.opencart.tests.currency;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AdminCurrencyPageBL;
import com.opencart.steps.AdminDashboardBL;
import com.opencart.steps.AdminLoginPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;

public class SetNewCurrencyTest extends BaseTest {
    private final String newCurrencyName = "UAH";
    private final String newCurrencyValue = "28.22";

    @Test (description = "test checks if customer can set new currency through Admin Page " +
            "and delete it successfully")
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
                .addNewCurrency(newCurrencyName, newCurrencyValue)
                .deleteCurrency(newCurrencyName)
                .verifySuccessCurrencyEdit();
    }
}
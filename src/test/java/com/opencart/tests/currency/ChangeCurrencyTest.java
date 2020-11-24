package com.opencart.tests.currency;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AdminCurrencyPageBL;
import com.opencart.steps.AdminDashboardBL;
import com.opencart.steps.AdminLoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.Map;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;
import static com.opencart.enums.URLs.BASE_URL;

public class ChangeCurrencyTest extends BaseTest {

    @Test(description = "Test checks if the cost of all products on the website's main page is correct " +
            "for currencies that are presented on admin page")
    public void ChangeCurrencyOnMainPageTest() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Currencies");
        Map<String, String> currencies = new AdminCurrencyPageBL().getCurrencyValues();
        new Navigation().navigateToURrl(BASE_URL.getValue());
        new MainPageBL().verifyAllProductsPrices(currencies);
    }
}
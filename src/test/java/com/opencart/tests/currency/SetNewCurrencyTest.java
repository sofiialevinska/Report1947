package com.opencart.tests.currency;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AdminDashboardBL;
import com.opencart.steps.AdminLoginPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;

public class SetNewCurrencyTest extends BaseTest {
    @Test
    public void setNewCurrencyTest() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        AdminLoginPageBL adminLoginPageBL = new AdminLoginPageBL()
                .adminLogin();
        AdminDashboardBL adminDashboardBL = new AdminDashboardBL()
                .clickOnSidebarButton("System")
                .clickOnSidebarButton("Localisation")
                .clickOnSidebarButton("Currencies")
                .clickOnAddNewCurrencyButton()
                .addNewCurrency();
    }
}

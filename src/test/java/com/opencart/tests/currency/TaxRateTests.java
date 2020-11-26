package com.opencart.tests.currency;

import com.opencart.navigation.Navigation;
import com.opencart.steps.*;
import com.opencart.tests.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;
import static com.opencart.enums.URLs.BASE_URL;

public class TaxRateTests extends BaseTest {
    private final String newVatTaxRateValue = "30";
    private final String newVatTaxRateName = "VAT (30%)";

    @BeforeClass
    public void editVatTaxRate() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Taxes")
                .clickOnLeftNavigationPanelButton("Tax Rates");
        new AdminTaxRatesPageBL()
                .editVatTaxRate(newVatTaxRateName, newVatTaxRateValue)
                .verifySuccessTaxRateEdit();
    }

    @Test(description = "Test checks if the cost of all products on the website's main page is correct " +
            "for new currencies that was set through admin page")
    public void checkProductPricesTest() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL

    }

    @AfterClass
    public void changeVatTaxRateToOriginalValue() {
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

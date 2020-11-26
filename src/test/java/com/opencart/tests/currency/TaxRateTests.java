package com.opencart.tests.currency;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AdminDashboardBL;
import com.opencart.steps.AdminLoginPageBL;
import com.opencart.steps.AdminTaxRatesPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;
import static com.opencart.enums.URLs.BASE_URL;

public class TaxRateTests extends BaseTest {
    private final String newVatTaxRateValue = "30";
    private final String newVatTaxRateName = "VAT (30%)";
    private final String originalVatTaxRateValue = "20";
    private final String originalVatTaxRateName = "VAT (20%)";
    private final String newEcoTaxRateValue = "4";
    private final String newEcoTaxRateName = "Eco Tax (-4.00)";
    private final String originalEcoTaxRateValue = "2";
    private final String originalEcoTaxRateName = "Eco Tax (-2.00)";

    @BeforeClass
    public void editTaxRates() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Taxes")
                .clickOnLeftNavigationPanelButton("Tax Rates");
        new AdminTaxRatesPageBL()
                .editVatTaxRate(originalVatTaxRateName, newVatTaxRateName, newVatTaxRateValue)
                .verifySuccessTaxRateEdit()
                .editVatTaxRate(originalEcoTaxRateName, newEcoTaxRateName, newEcoTaxRateValue)
                .verifySuccessTaxRateEdit();
    }

    @Test(description = "Test checks if the cost of all products on the website's main page is correct " +
            "for new currencies that was set through admin page")
    public void checkProductTaxRateTest() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        MainPageBL mainPageBL = new MainPageBL();
        mainPageBL
                .getHeaderPageBL()
                .clickOnMacbookAddToCartButton()
                .clickOnShoppingCartButton()
                .verifyMacBookVatTaxRateName(newVatTaxRateName, newVatTaxRateValue)
                .verifyMacBookEcoTaxRateName(newEcoTaxRateName,newEcoTaxRateValue)
                .verifyMacBookTotalPrice(newVatTaxRateValue,newEcoTaxRateValue);
    }

    @AfterClass
    public void changeVatTaxRateToOriginalValue() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Taxes")
                .clickOnLeftNavigationPanelButton("Tax Rates");
        new AdminTaxRatesPageBL()
                .editVatTaxRate(newVatTaxRateName, originalVatTaxRateName, originalVatTaxRateValue)
                .verifySuccessTaxRateEdit()
                .editVatTaxRate(newEcoTaxRateName, originalEcoTaxRateName, originalEcoTaxRateValue)
                .verifySuccessTaxRateEdit();
    }
}

package com.opencart.tests.currency;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AdminDashboardBL;
import com.opencart.steps.AdminLoginPageBL;
import com.opencart.steps.AdminTaxRatesPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.opencart.enums.URLs.ADMIN_BASE_URL;
import static com.opencart.enums.URLs.BASE_URL;

public class TaxRateTests extends BaseTest {

    @Severity(value = SeverityLevel.NORMAL)
    @Test(description = "Test checks if the taxRates of all products on the website's main page " +
            "equals Tax Rates that are set on the Admin Page")
    public void checkAdminTaxRates() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Taxes")
                .clickOnLeftNavigationPanelButton("Tax Rates");
        Map<String, String> taxRates = new AdminTaxRatesPageBL().getTaxRatesValues();
        new Navigation().navigateToURrl(BASE_URL.getValue());
        new MainPageBL().verifyAllProductsTaxRates(taxRates);
    }

    @Severity(value = SeverityLevel.MINOR)
    @Test(description = "Test edits existing TaxRates through Admin Page and " +
            "checks if the taxRates of all products on the website's main page is correct for new Tax Rates")
    public void editTaxRatesCheckMain() {
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Taxes")
                .clickOnLeftNavigationPanelButton("Tax Rates");
        Map<String, String> originalTaxRates = new AdminTaxRatesPageBL().getTaxRatesValues();
        Map<String, String> newTaxRates = new HashMap<>();
        String newVatTaxRateValue = "30";
        String newVatTaxRateName = "VAT (30%)";
        String newEcoTaxRateValue = "4";
        String newEcoTaxRateName = "Eco Tax (-4.00)";
        newTaxRates.put(newVatTaxRateName, newVatTaxRateValue);
        newTaxRates.put(newEcoTaxRateName, newEcoTaxRateValue);
        new AdminTaxRatesPageBL()
                .editVatTaxRate(originalTaxRates, newTaxRates)
                .verifySuccessTaxRateEdit();
        new Navigation().navigateToURrl(BASE_URL.getValue());
        new MainPageBL().verifyAllProductsTaxRates(newTaxRates);
        new Navigation().navigateToURrl(ADMIN_BASE_URL.getValue());
        new AdminLoginPageBL().adminLogin();
        new AdminDashboardBL()
                .getAdminLeftNavigationPanelPageBL()
                .clickOnLeftNavigationPanelButton("System")
                .clickOnLeftNavigationPanelButton("Localisation")
                .clickOnLeftNavigationPanelButton("Taxes")
                .clickOnLeftNavigationPanelButton("Tax Rates");
        new AdminTaxRatesPageBL()
                .editVatTaxRate(newTaxRates, originalTaxRates)
                .verifySuccessTaxRateEdit();
    }
}
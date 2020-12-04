package com.opencart.steps;

import com.opencart.containers.TaxRatesContainerAdmin;
import com.opencart.pages.AdminTaxRatesPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminTaxRatesPageBL {
    private final AdminTaxRatesPage adminTaxRatesPage;

    public AdminTaxRatesPageBL() {
        adminTaxRatesPage = new AdminTaxRatesPage();
    }

    @Step("put Tax Rates names and values from Admin Page to Map <String,String>")
    public Map<String, String> getTaxRatesValues() {
        Map<String, String> taxRatesMap = new HashMap<>();
        List<TaxRatesContainerAdmin> taxRatesContainerAdmin = new AdminTaxRatesPage().getTaxRatesContainersAdmin();
        for (TaxRatesContainerAdmin container
                : taxRatesContainerAdmin) {
            if (!container.getTaxRate().contains("Tax")) {
                taxRatesMap.put(container.getTaxName(), container.getTaxRate());
            }
        }
        return taxRatesMap;
    }

    @Step("editVatTaxRate through Admin Page")
    public AdminTaxRatesPageBL editVatTaxRate(Map<String, String> originalTaxRates, Map<String, String> newTaxRates) {
        originalTaxRates.forEach((originalTaxRateName, originalTaxRateValue) -> {
            clickOnEditTaxRateButton(originalTaxRateName);
            newTaxRates.forEach((newTaxRateName, newTaxRateValue) -> {
                if (newTaxRateName.contains(originalTaxRateName.substring(0, 3))) {
                    inputTaxName(newTaxRateName);
                    inputTaxRate(newTaxRateValue);
                }
            });
            clickOnSaveTaxRateButton();
        });
        return this;
    }

    private void clickOnEditTaxRateButton(String taxRateName) {
        List<TaxRatesContainerAdmin> taxRatesContainerAdmin = new AdminTaxRatesPage().getTaxRatesContainersAdmin();
        for (TaxRatesContainerAdmin container
                : taxRatesContainerAdmin) {
            if (container.getTaxName().equals(taxRateName)) {
                container.getEditTaxRateButton().click();
                break;
            }
        }
    }

    private void inputTaxName(String taxRateName) {
        adminTaxRatesPage.getInputTaxRateName().clear();
        adminTaxRatesPage.getInputTaxRateName().sendKeys(taxRateName);
    }

    private void inputTaxRate(String taxRateValue) {
        adminTaxRatesPage.getInputTaxRateValue().clear();
        adminTaxRatesPage.getInputTaxRateValue().sendKeys(taxRateValue);
    }

    private void clickOnSaveTaxRateButton() {
        adminTaxRatesPage.getSaveTaxRateChangesButton().click();
    }

    @Step("verifySuccessTaxRateEdit")
    public AdminTaxRatesPageBL verifySuccessTaxRateEdit() {
        String expectedSuccessMessage = "Success: You have modified tax rates!";
        Assert.assertTrue(adminTaxRatesPage.getSuccessTaxRateEditMessage().getText().contains(expectedSuccessMessage), "\nSuccess message about successful Tax Rate change through the Admin Page did not appear.");
        return this;
    }
}

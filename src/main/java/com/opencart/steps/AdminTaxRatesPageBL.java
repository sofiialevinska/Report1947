package com.opencart.steps;

import com.opencart.containers.TaxRatesContainerAdmin;
import com.opencart.pages.AdminTaxRatesPage;
import com.opencart.util.DriverUtils;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminTaxRatesPageBL {
    private final AdminTaxRatesPage adminTaxRatesPage;

    public AdminTaxRatesPageBL() {
        adminTaxRatesPage = new AdminTaxRatesPage();
    }

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

    public AdminTaxRatesPageBL editVatTaxRate (String newTaxRateName, String newTaxRate) {
        clickOnEditTaxRateButton(newTaxRateName);
        inputTaxName(newTaxRateName);
        inputTaxRate(newTaxRate);
        clickOnSaveTaxRateButton();
    }

    private void clickOnEditTaxRateButton (String taxRateName) {
        List<TaxRatesContainerAdmin> taxRatesContainerAdmin = new AdminTaxRatesPage().getTaxRatesContainersAdmin();
        for (TaxRatesContainerAdmin container
                : taxRatesContainerAdmin) {
            if (container.getTaxName().equals(taxRateName)) {
                container.getEditTaxRateButton().click();
                break;
            }
        }
    }

    private void inputTaxName (String taxRateName){
        adminTaxRatesPage.getInputTaxRateName().clear();
        adminTaxRatesPage.getInputTaxRateName().sendKeys(taxRateName);
    }

    private void inputTaxRate (String taxRateValue) {
        adminTaxRatesPage.getInputTaxRateValue().clear();
        adminTaxRatesPage.getInputTaxRateValue().sendKeys(taxRateValue);
    }

    private void clickOnSaveTaxRateButton() {
        adminTaxRatesPage.getSaveTaxRateChangesButton().click();
    }

    public AdminTaxRatesPageBL deleteTaxRate(String taxName) {
        clickOnTaxRateCheckbox(taxName);
        clickOnDeleteTaxRateButton();
        verifySuccessTaxRateEdit();
        return this;
    }

    private void clickOnTaxRateCheckbox(String taxName) {
        List<TaxRatesContainerAdmin> taxRatesContainerAdmin = new AdminTaxRatesPage().getTaxRatesContainersAdmin();
        for (TaxRatesContainerAdmin container
                : taxRatesContainerAdmin) {
            if (container.getTaxName().equals(taxName)) {
                new DriverUtils().clickOnElementJS(container.getTaxRateCheckbox());
                break;
            }
        }
    }

    private void clickOnDeleteTaxRateButton() {
        adminTaxRatesPage.getDeleteTaxRateButton().click();
        new DriverUtils().acceptAlert();
    }

    public AdminTaxRatesPageBL verifySuccessTaxRateEdit() {
        String expectedSuccessMessage = "Success: You have modified tax rates!";
        Assert.assertTrue(adminTaxRatesPage.getSuccessTaxRateEditMessage().getText().contains(expectedSuccessMessage), "\nSuccess message about successful Tax Rate change through the Admin Page did not appear.");
        return this;
    }
}

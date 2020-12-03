package com.opencart.pages;

import com.opencart.containers.TaxRatesContainerAdmin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class AdminTaxRatesPage extends BasePage{

    @FindBy(css = "[type='submit']")
    WebElement saveTaxRateChangesButton;

    @FindBy(id = "input-name")
    WebElement inputTaxRateName;

    @FindBy(id = "input-rate")
    WebElement inputTaxRateValue;

    @FindBy(css = ".alert.alert-success")
    WebElement successTaxRateEditMessage;

    @FindBy(css = "tr")
    private List<WebElement> taxRatesAdmin;

    public List<TaxRatesContainerAdmin> getTaxRatesContainersAdmin() {
        wait.until(ExpectedConditions.visibilityOfAllElements(taxRatesAdmin));
        return taxRatesAdmin.stream()
                .map(TaxRatesContainerAdmin::new)
                .collect(Collectors.toList());
    }

    public WebElement getInputTaxRateName() {
        wait.until(ExpectedConditions.visibilityOf(inputTaxRateName));
        return inputTaxRateName;
    }

    public WebElement getSaveTaxRateChangesButton() {
        return saveTaxRateChangesButton;
    }

    public WebElement getInputTaxRateValue() {
        wait.until(ExpectedConditions.visibilityOf(inputTaxRateValue));
        return inputTaxRateValue;
    }

    public WebElement getSuccessTaxRateEditMessage() {
        return successTaxRateEditMessage;
    }
}

package com.opencart.steps;

import com.opencart.pages.HeaderPage;
import org.testng.Assert;

public class HeaderPageBL {
    private final HeaderPage headerPage;

    public HeaderPageBL() {
        headerPage = new HeaderPage();
    }

    public HeaderPageBL clickOnChangeCurrencyButton() {
        headerPage.getCurrencyButton().click();
        return this;
    }

    public HeaderPageBL clickOnEurButton(String currencyName) {
        headerPage.getCurrencyButton(currencyName).click();
        return this;
    }

    public void verifyMacBookCost(String currencyName) {
        String expectedCost = null;
        switch (currencyName.toLowerCase()) {
            case "eur":
                expectedCost = "472.33€";
                break;
            case "usd":
                expectedCost = "602.00";
                break;
            case "gbp":
                expectedCost = "368.73";
                break;
            case "uah":
                expectedCost = "16985.77";
                break;
        }
        Assert.assertTrue(headerPage.getMacBookCost().getText().contains(expectedCost), "Incorrect MacBook cost in " + currencyName + ". Please try again.");
    }
}

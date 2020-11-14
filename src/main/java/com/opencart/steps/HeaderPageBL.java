package com.opencart.steps;

import com.opencart.pages.HeaderPage;
import org.testng.Assert;

public class HeaderPageBL {
    private final HeaderPage headerPage;

    public HeaderPageBL() {
        headerPage = new HeaderPage();
    }

    /**
     * Method clicks on Change Currency button that is located in website's header.
     *
     * @return HeaderPageBL
     */

    public HeaderPageBL clickOnChangeCurrencyButton() {
        headerPage.getCurrencyButton().click();
        return this;
    }

    /**
     * Method clicks on specified currency button that is located in website's header.
     *
     * @param currencyName is a name of Currency, which button needs to be clicked.
     * @return HeaderPageBL
     */

    public HeaderPageBL clickOnCurrencyButton(String currencyName) {
        headerPage.getCurrencyButton(currencyName).click();
        return this;
    }

    /**
     * Method checks if MacBook Cost in specified currency is correct.
     *
     * @param currencyName is a name of Currency that needs to be checked.
     * @return HeaderPageBL
     */

    public HeaderPageBL verifyMacBookCost(String currencyName) {
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
                expectedCost = "16,988";
                break;
        }
        Assert.assertTrue(headerPage.getMacBookCost().getText().contains(expectedCost), "\nIncorrect MacBook cost in " + currencyName + ". Please try again.");
        return this;
    }
}

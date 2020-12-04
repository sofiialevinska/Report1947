package com.opencart.steps;

import com.opencart.containers.ProductContainer;
import com.opencart.datamodel.ProductModel;
import com.opencart.pages.SearchResultPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class MainPageBL {

    public HeaderPageBL getHeaderPageBL() {
        return new HeaderPageBL();
    }

    @Step ("Verify that all Product's Costs from the Main Page in specified currency are correct")
    /**
     * Method finds all ProductContainers on the Page and checks
     * if their Product Cost in specified currency is correct.
     *
     * @param currencies is a Map<String, String> with currencies Codes and Values that was read
     *                   from the Admin Page.
     */
    public void verifyAllProductsPrices(Map<String, String> currencies) {
        currencies.forEach((currencyName, currencyValue) -> {
            getHeaderPageBL()
                    .clickOnChangeCurrencyButton()
                    .clickOnCurrencyButton(currencyName);
            List<ProductContainer> productContainers = new SearchResultPage().getProductContainers();
            for (ProductContainer container
                    : productContainers) {
                verifyProductPrice(container, currencyName, currencyValue);
            }
        });
    }

    @Step ("Verify that all Product's Costs from the Main Page in specified currency are correct")
    /**
     * Method finds all ProductContainers on the Main Page and checks
     * if their Product Cost in specified currency is correct.
     *
     * @param currencyName  is name of Currency that needs to be checked.
     * @param currencyValue is price index in comparison to USD of Currency that needs to be checked.
     */
    public void verifyAllProductsPrices(String currencyName, String currencyValue) {
        List<ProductContainer> productContainers = new SearchResultPage().getProductContainers();
        for (ProductContainer container
                : productContainers) {
            verifyProductPrice(container, currencyName, currencyValue);
        }
    }

    /**
     * Method checks if MacBook Cost in specified currency is correct.
     *
     * @param container     is Container for Products where price needs to be checked;
     * @param currencyName  is name of Currency that needs to be checked.
     * @param currencyValue is price index in comparison to USD of Currency that needs to be checked.
     */
    private void verifyProductPrice(ProductContainer container, String currencyName, String currencyValue) {
        new ProductModel();
        Double expectedPrice = getExpectedPrice(container, currencyValue);
        String expectedPriceString;
        if (expectedPrice > 1000) {
            expectedPriceString = String.format("%,3.0f", expectedPrice);
        } else {
            expectedPriceString = String.format("%.2f", expectedPrice);
        }
        Assert.assertTrue(container.getPrice().contains(expectedPriceString), "\nError. "
                + container.getName() + " price in " + currencyName + " is invalid.");
    }

    /**
     * Method calculates expected price for Product in ProductContainer in specified currency
     * by multiplying ProductPrice in USD (from Product Model) to currency Value (that was read
     * from the Admin Page).
     *
     * @param container     is Container for Products where price needs to be checked;
     * @param currencyValue is price index in comparison to USD of Currency that needs to be checked.
     * @return double expected price for Product in Container.
     */
    private double getExpectedPrice(ProductContainer container, String currencyValue) {
        return ProductModel.getProductPriceInUSD(container.getName()) *
                Double.parseDouble(currencyValue);
    }

    @Step ("Verify that all Product's Tax Rates from the Main Page in USD are correct")
    /**
     * Method verifies if TaxRates that are shown in the shopping cart
     * for first two products on the Main page are correct.
     *
     * @param taxRates is a map with tax rate name and tax rate value.
     */
    public void verifyAllProductsTaxRates(Map<String, String> taxRates) {
        List<ProductContainer> productContainers = new SearchResultPage().getProductContainers();
        for (ProductContainer container
                : productContainers) {
            clickOnAddToCartButton(container);
            getHeaderPageBL().clickOnShoppingCartButton();
            taxRates.forEach((taxRateName, taxRateValue) -> {
                getHeaderPageBL().verifyProductTaxRate(container, taxRateName, taxRateValue);
            });
            getHeaderPageBL()
                    .verifyProductTotalPrice(taxRates)
                    .clickOnDeleteFromShoppingCartButton();
            if (container.getName().contains("iPhone")) {
                break;
            }
        }
    }

    /**
     * Method clicks on Button that Adds Product in ProductContainer to the cart.
     *
     * @param container is Container for Products where price needs to be checked;
     */
    private void clickOnAddToCartButton(ProductContainer container) {
        container.getShoppingCartButton().click();
    }
}
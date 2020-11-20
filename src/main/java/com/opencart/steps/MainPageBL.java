package com.opencart.steps;

import com.opencart.containers.ProductContainer;
import com.opencart.datamodel.ProductModel;
import com.opencart.pages.SearchResultPage;
import org.testng.Assert;

import java.util.List;

public class MainPageBL {

    public HeaderPageBL getHeaderPageBL() {
        return new HeaderPageBL();
    }

    /**
     * Method finds all ProductContainers on the Page and checks
     * if their Product Cost in specified currency is correct.
     *
     * @param currencyName is name of Currency that needs to be checked.
     */

    public void verifyAllProductsPrices(String currencyName) {
        List<ProductContainer> productContainers = new SearchResultPage().getProductContainers();
        for (ProductContainer container
                : productContainers) {
            verifyProductPrice(container, currencyName);
        }
    }

    /**
     * Method checks if MacBook Cost in specified currency is correct.
     *
     * @param container    is Container for Products where price needs to be checked;
     * @param currencyName is name of Currency that needs to be checked.
     */
    private void verifyProductPrice(ProductContainer container, String currencyName) {
        new ProductModel();
        double expectedCost = ProductModel.getProductPrice(container.getName());
        switch (currencyName.toLowerCase()) {
            case "usd":
                break;
            case "eur":
                expectedCost = expectedCost * 0.78460002;
                break;
            case "gbp":
                expectedCost = expectedCost * 0.61250001;
                break;
            case "uah":
                expectedCost = expectedCost * 28.22000000;
                break;
        }
        String expectedPrice;
        if (expectedCost > 1000) {
            expectedPrice = String.format("%,3.0f", expectedCost);
        } else {
            expectedPrice = String.format("%.2f", expectedCost);
        }
        Assert.assertTrue(container.getPrice().contains(expectedPrice), "123");
    }
}


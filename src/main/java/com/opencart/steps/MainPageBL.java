package com.opencart.steps;

import com.opencart.containers.ProductContainer;
import com.opencart.datamodel.CurrencyModel;
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
//        new CurrencyModel();
        Double expectedPrice = getExpectedPrice(container, currencyName);
        String expectedPriceString;
        if (expectedPrice > 1000) {
            expectedPriceString = String.format("%,3.0f", expectedPrice);
        } else {
            expectedPriceString = String.format("%.2f", expectedPrice);
        }
        Assert.assertTrue(container.getPrice().contains(expectedPriceString), "\nError. "
                + container.getName() + " price in " + currencyName + "is invalid.");
    }


    /**
     * Method calculates expected price for Product in ProductContainer in specified currency
     * by multiplying ProductPrice in USD (from Product Model) to currency Value (that was read
     * from the Admin Page).
     *
     * @param container    is Container for Products where price needs to be checked;
     * @param currencyName is name of Currency that needs to be checked.
     *
     * @return double expected price for Product in Container.
     */
    private double getExpectedPrice(ProductContainer container, String currencyName) {
        return ProductModel.getProductPriceInUSD(container.getName()) *
                Double.parseDouble(CurrencyModel.getCurrencyValue(currencyName));
    }
}


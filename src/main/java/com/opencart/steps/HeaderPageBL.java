package com.opencart.steps;

import com.opencart.containers.ProductContainer;
import com.opencart.datamodel.ProductModel;
import com.opencart.pages.HeaderPage;
import com.opencart.pages.SearchResultPage;
import org.testng.Assert;

import java.util.List;

public class HeaderPageBL {
    private final HeaderPage headerPage;

    public HeaderPageBL() {
        headerPage = new HeaderPage();
    }

    public void searchProduct(String product) {
        clickOnSearchInput();
        inputSearch(product);
        clickOnSearchButton();
    }

    private void clickOnSearchInput() {
        headerPage.getSearchInput().click();
    }

    private void inputSearch(String search) {
        headerPage.getSearchInput().clear();
        headerPage.getSearchInput().sendKeys(search);
    }

    private void clickOnSearchButton() {
        headerPage.getSearchButton().click();
    }

    public HeaderPageBL clickOnMyAccountButton() {
        headerPage.getMyAccountButton().click();
        return this;
    }

    public HeaderPageBL clickOnLoginButton() {
        headerPage.getLoginButton().click();
        return this;
    }

    public RegisterPageBL clickOnRegisterButton() {
        headerPage.getRegisterButton().click();
        return new RegisterPageBL();
    }

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
     * Method finds all ProductContainers on the Page and checks
     * if their Product Cost in specified currency is correct.
     *
     * @param currencyName is name of Currency that needs to be checked.
     */

    public void verifyAllProductsPrices(String currencyName) {
        List<ProductContainer> productContainers = new SearchResultPage().getProductContainers();
        for (ProductContainer container
                : productContainers) {
            verifyProductCost(container, currencyName);
        }
    }

    /**
     * Method checks if MacBook Cost in specified currency is correct.
     *
     * @param container    is Container for Products where price needs to be checked;
     * @param currencyName is name of Currency that needs to be checked.
     */
    private void verifyProductCost(ProductContainer container, String currencyName) {
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

    public HeaderPageBL clickOnLogoutButton() {
        headerPage.getLogoutButton().click();
        return this;
    }
}

package com.opencart.steps;

import com.opencart.containers.ProductContainer;
import com.opencart.datamodel.ProductModel;
import com.opencart.pages.HeaderPage;
import org.testng.Assert;

public class HeaderPageBL {
    private final HeaderPage headerPage;

    public HeaderPageBL() {
        headerPage = new HeaderPage();
    }

    private void clickOnSearchInput() {
        headerPage.getSearchInput().click();
    }

    private void clickOnSearchButton() {
        headerPage.getSearchButton().click();
    }

    public void searchProduct(String product) {
        clickOnSearchInput();
        inputSearch(product);
        clickOnSearchButton();
    }

    private void inputSearch(String search) {
        headerPage.getSearchInput().clear();
        headerPage.getSearchInput().sendKeys(search);
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
     * @param container is Container for Products where price needs to be checked;
     * @param currencyName is name of Currency that needs to be checked.
     * @return HeaderPageBL
     */

    public HeaderPageBL verifyMacBookCost(ProductContainer container, String currencyName) {

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

        String expectedPrice = null;
        if (expectedCost > 1000) {
            expectedPrice = String.format("%,3.0f", expectedCost);
        } else {
            expectedPrice = String.format("%.2f", expectedCost);
        }
        System.out.println("container.getPrice()  = " + container.getPrice());
        System.out.println("expectedPrice (calculated) = " + expectedPrice);
        Assert.assertTrue(container.getPrice().contains(expectedPrice), "123");
        return this;
    }


    public HeaderPageBL clickOnLogoutButton() {
        headerPage.getLogoutButton().click();
        return this;
    }
}

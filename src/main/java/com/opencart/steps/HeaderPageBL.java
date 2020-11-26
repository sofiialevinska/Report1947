package com.opencart.steps;

import com.opencart.pages.HeaderPage;
import org.testng.Assert;

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

    public HeaderPageBL clickOnChangeCurrencyButton() {
        headerPage.getCurrencyButton().click();
        return this;
    }

    public HeaderPageBL clickOnCurrencyButton(String currencyName) {
        headerPage.getCurrencyButton(currencyName).click();
        return this;
    }

    public HeaderPageBL clickOnLogoutButton() {
        headerPage.getLogoutButton().click();
        return this;
    }

    public HeaderPageBL clickOnMacbookAddToCartButton() {
        headerPage.getMacbookAddToCartButton().click();
        return this;
    }

    public HeaderPageBL clickOnShoppingCartButton() {
        headerPage.getShoppingCartButton().click();
        return this;
    }

    public HeaderPageBL verifyMacBookVatTaxRateName(String newVatTaxRateName, String newVatTaxRateValue) {
        String expectedResult = String.valueOf(Double.parseDouble(headerPage.getProductPrice().getText().
                replaceAll("\\D+", "")) * (Double.parseDouble(newVatTaxRateValue)) / 10000);
        Assert.assertTrue(headerPage.getProductVatTaxRate().getText().contains(expectedResult),
                "Vat Tax Rate Value of MacBook product in the shopping cart is incorrect");
        Assert.assertEquals(headerPage.getProductVatTaxName().getText(), newVatTaxRateName,
                "Vat Tax Rate Name in the shopping cart is incorrect");
        return this;
    }

    public HeaderPageBL verifyMacBookEcoTaxRateName(String newEcoTaxRateName, String newEcoTaxRateValue) {
        Assert.assertTrue(headerPage.getProductEcoTaxRate().getText().contains(newEcoTaxRateValue),
                "Eco Tax Rate Value of MacBook product in the shopping cart is incorrect");
        Assert.assertEquals(headerPage.getProductEcoTaxName().getText(), newEcoTaxRateName,
                "Eco Tax Rate Name in the shopping cart is incorrect");
        return this;
    }

    public HeaderPageBL verifyMacBookTotalPrice(String newVatTaxRateValue, String newEcoTaxRateValue) {
        String expectedResult = String.valueOf(((Double.parseDouble(headerPage.getProductPrice().getText().
                replaceAll("\\D+", "")) * Double.parseDouble(newVatTaxRateValue)) / 10000 +
                Double.parseDouble(headerPage.getProductPrice().getText().replaceAll("\\D+", "")) / 100) +
                Double.parseDouble(newEcoTaxRateValue));
        Assert.assertTrue(headerPage.getProductTotalPrice().getText().contains(expectedResult),
                "Total Price Value of MacBook product in the shopping cart is incorrect");
        return this;
    }
}

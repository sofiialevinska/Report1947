package com.opencart.steps;

import com.opencart.containers.ProductContainer;
import com.opencart.pages.HeaderPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.Map;

public class HeaderPageBL {
    public String newVatTaxRateValue = null;
    public String newEcoTaxRateValue = null;
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

    @Step("clickOnMyAccountButton")
    public HeaderPageBL clickOnMyAccountButton() {
        headerPage.getMyAccountButton().click();
        return this;
    }

    @Step("clickOnLoginButton")
    public HeaderPageBL clickOnLoginButton() {
        headerPage.getLoginButton().click();
        return this;
    }

    @Step("clickOnRegisterButton")
    public RegisterPageBL clickOnRegisterButton() {
        headerPage.getRegisterButton().click();
        return new RegisterPageBL();
    }

    @Step("clickOnChangeCurrencyButton")
    public HeaderPageBL clickOnChangeCurrencyButton() {
        headerPage.getCurrencyButton().click();
        return this;
    }

    @Step("clickOnCurrencyButton")
    public HeaderPageBL clickOnCurrencyButton(String currencyName) {
        headerPage.getCurrencyButton(currencyName).click();
        return this;
    }

    @Step("clickOnLogoutButton")
    public HeaderPageBL clickOnLogoutButton() {
        headerPage.getLogoutButton().click();
        return this;
    }

    @Step("clickOnDeleteFromShoppingCartButton")
    public HeaderPageBL clickOnShoppingCartButton() {
        headerPage.getShoppingCartButton().click();
        return this;
    }

    @Step("Verify that all Product's TaxRates from the Main Page in specified currency are correct")
    public HeaderPageBL verifyProductTaxRate(ProductContainer container, String taxRateName, String taxRateValue) {
        if (taxRateName.contains("VAT")) {
            String expectedResult = String.valueOf(Double.parseDouble(headerPage.getProductPrice().getText().
                    replaceAll("\\D+", "")) * (Double.parseDouble(taxRateValue)) / 10000);
            Assert.assertTrue(headerPage.getProductVatTaxRate().getText().contains(expectedResult),
                    "Vat Tax Rate Value of " + container.getName() + " product in the shopping cart is incorrect");
            Assert.assertEquals(headerPage.getProductVatTaxName().getText(), taxRateName,
                    "Vat Tax Rate Name of " + container.getName() + " product in the shopping cart is incorrect");
            return this;
        } else {
            String expectedResult = String.format("%,.2f", Double.parseDouble(taxRateValue));
            Assert.assertTrue(headerPage.getProductEcoTaxRate().getText().contains(expectedResult),
                    "Eco Tax Rate Value of " + container.getName() + " product the shopping cart is incorrect");
            Assert.assertEquals(headerPage.getProductEcoTaxName().getText(), taxRateName,
                    "Eco Tax Rate Name of " + container.getName() + " product in the shopping cart is incorrect");
            return this;
        }
    }

    @Step ("Verify that all Product's Total Prices from the Main Page in specified currency are correct")
    public HeaderPageBL verifyProductTotalPrice(Map<String, String> taxRates) {
        taxRates.forEach((taxRateName, taxRateValue) -> {
            if (taxRateName.contains("VAT")) {
                newVatTaxRateValue = taxRateValue;
            }
            if (taxRateName.contains("Eco")) {
                newEcoTaxRateValue = taxRateValue;
            }
        });
        String expectedResult = String.valueOf(((Double.parseDouble(headerPage.getProductPrice().getText().
                replaceAll("\\D+", "")) * Double.parseDouble(newVatTaxRateValue)) / 10000 +
                Double.parseDouble(headerPage.getProductPrice().getText().replaceAll("\\D+", "")) / 100) +
                Double.parseDouble(newEcoTaxRateValue));
        Assert.assertTrue(headerPage.getProductTotalPrice().getText().contains(expectedResult),
                "Total Price Value of MacBook product in the shopping cart is incorrect");
        return this;
    }

    @Step ("clickOnDeleteFromShoppingCartButton")
    public HeaderPageBL clickOnDeleteFromShoppingCartButton() {
        headerPage.getDeleteFromShoppingCartButton().click();
        return this;
    }
}

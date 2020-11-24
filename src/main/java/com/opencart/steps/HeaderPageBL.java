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

    public LoginPageBL clickOnLoginButton() {
        headerPage.getLoginButton().click();
        return new LoginPageBL();
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

    public HeaderPageBL clickOnLogoutButton() {
        headerPage.getLogoutButton().click();
        return this;
    }

    public HeaderPageBL clickOnWishListButton() {
        headerPage.getWishListButton().click();
        return this;
    }

    public HeaderPageBL clickOnMacbookWishListButton() {
        headerPage.getMacbookWishListButton().click();
        return this;
    }

    public void verifyAddingMacbookToWishList() {
        String expected = "Wish List (1)";
        Assert.assertEquals(headerPage.getWishListButton().getText(), expected, "Incorrect value!");
    }
}
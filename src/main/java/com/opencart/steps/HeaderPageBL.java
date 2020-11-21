package com.opencart.steps;

import com.opencart.pages.HeaderPage;
//import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import org.testng.Assert;

public class HeaderPageBL {
    private HeaderPage headerPage;

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

    /**
     * Method clicks on My Account button that is located in website's header.
     *
     * @return HeaderPageBL
     */
    public HeaderPageBL clickOnMyAccountButton() {
        headerPage.getMyAccountButton().click();
        return this;
    }

    /**
     * Method clicks on Login button that is located in website's header.
     *
     * @return HeaderPageBL
     */
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
     * @param currencyName is a name of Currency that needs to be checked.
     * @return HeaderPageBL
     */
    public HeaderPageBL verifyMacBookCost(String currencyName) {
        String expectedCost = null;
        switch (currencyName.toLowerCase()) {
            case "eur":
                expectedCost = "392.30€";
                break;
            case "usd":
                expectedCost = "$500.00";
                break;
            case "gbp":
                expectedCost = "£306.25";
                break;
            case "uah":
                expectedCost = "14,110UAH";
                break;
        }
        Assert.assertTrue(headerPage.getMacBookCost().getText().contains(expectedCost), "\nIncorrect MacBook cost in " + currencyName + ". Please try again.");
        return this;
    }

    /**
     * Method clicks on Logout button that is located in website's header.
     *
     * @return HeaderPageBL
     */
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

    public SearchResultPageBL getSearchResultPageBL() {
        return new SearchResultPageBL();
    }

    public void clickOnShoppingCartSpan() {
        headerPage.getShoppingCartSpan().click();
    }

    public ShoppingCartPageBL getShoppingCartPageBL() {
        return new ShoppingCartPageBL();
    }
}

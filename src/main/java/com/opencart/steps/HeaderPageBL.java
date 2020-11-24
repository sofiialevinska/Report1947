package com.opencart.steps;

import com.opencart.pages.HeaderPage;
import com.opencart.pages.LoginPage;
import org.openqa.selenium.WebElement;
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

    public HeaderPageBL clickOnCurrencyButton(String currencyName) {
        headerPage.getCurrencyButton(currencyName).click();
        return this;
    }

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

    public HeaderPageBL clickOnLogoutButton() {
        headerPage.getLogoutButton().click();
        return this;
    }

    public WishListPageBL clickOnWishListButton() {
        headerPage.getWishListButton().click();
        return new WishListPageBL();
    }

    public HeaderPageBL clickOnMacbookWishListButton() {
        headerPage.getMacbookWishListButton().click();
        return this;
    }

    public void verifyAddingMacbookToWishListWithoutLogin() {
        String expected = "You must login or create an account to save MacBook to your wish list!";
        String actual = headerPage.getSuccessMessage().getText().replaceAll("×", " ").trim();
        Assert.assertEquals(actual, expected, "You are logged In!");
    }

    public void verifyAddingMacbookInWishListWithLogin() {
        String expected = "Success: You have added MacBook to your wish list!";
        String actual = headerPage.getSuccessMessage().getText().replaceAll("×", " ").trim();
        Assert.assertEquals(actual, expected, "You are not logged in!");
    }

    public void verifyChangingOfValueInWishList() {
        String expected = "Wish List (1)";
        String actual = headerPage.getWishListButton().getText()
                .replaceAll("×", " ").trim();
        Assert.assertEquals(actual, expected, "You didn't add anything in wish list");
    }

    public SearchResultPageBL getSearchResultPageBL() {
        return new SearchResultPageBL();
    }
}

package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

    @FindBy(xpath = ".//*[@title='My Account']")
    private WebElement myAccountButton;

    @FindBy(xpath = ".//*[contains (@href,'register')]")
    private WebElement registerButton;

    @FindBy(xpath = ".//*[contains (@href, 'login')]")
    private WebElement loginButton;

    @FindBy(id = "form-currency")
    private WebElement currencyButton;

    @FindBy(name = "EUR")
    private WebElement euroButton;

    @FindBy(name = "USD")
    private WebElement usdButton;

    @FindBy(name = "GBP")
    private WebElement gbpButton;

    @FindBy(name = "UAH")
    private WebElement uahButton;

    @FindBy(css = "div.product-thumb.transition:first-child")
    private WebElement macBookCost;

    @FindBy(xpath = ".//*[contains (@href, 'account/logout')]")
    private WebElement logoutButton;

    @FindBy(css = "input[name = 'search']")
    private WebElement searchInput;

    @FindBy(css = "* button > i.fa.fa-search")
    private WebElement searchButton;

    @FindBy(css = "i[class=\"fa fa-heart\"] + .hidden-xs.hidden-sm.hidden-md")
    private WebElement wishListButton;

    @FindBy(css = "button[onclick=\"wishlist.add('43');\"]")
    private WebElement macbookWishListButton;

    /**
     * Method gets My Account Button that is located in the website's header
     *
     * @return WebElement My Account Button that is located in the website's header
     */

    public WebElement getMyAccountButton() {
        wait.until(ExpectedConditions.visibilityOf(myAccountButton));
        return myAccountButton;
    }

    /**
     * Method gets Login Button that is located in the website's header
     *
     * @return WebElement Login Button that is located in the website's header
     */

    public WebElement getLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton;
    }

    public WebElement getCurrencyButton() {
        wait.until(ExpectedConditions.visibilityOf(currencyButton));
        return currencyButton;
    }

    public WebElement getRegisterButton() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        return registerButton;
    }

    public WebElement getWishListButton() {
        return wishListButton;
    }

    /**
     * Method gets specified Currency Button from the Website's header
     *
     * @param currencyName is a name Currency Button method needs to find
     * @return WebElement Currency Button of specified currency
     */

    public WebElement getCurrencyButton(String currencyName) {
        switch (currencyName.toLowerCase()) {
            case "eur":
                wait.until(ExpectedConditions.visibilityOf(euroButton));
                return euroButton;
            case "usd":
                wait.until(ExpectedConditions.visibilityOf(usdButton));
                return usdButton;
            case "gbp":
                wait.until(ExpectedConditions.visibilityOf(gbpButton));
                return gbpButton;
            case "uah":
                wait.until(ExpectedConditions.visibilityOf(gbpButton));
                return uahButton;
            default: {
                System.err.println("\nCan not switch to " + currencyName + " currency because this currency is not available. Please try again with another currency.");
                return null;
            }
        }
    }

    /**
     * Method gets MacBook Cost
     *
     * @return WebElement text that contains MacBook Cost
     */

    public WebElement getMacBookCost() {
        wait.until(ExpectedConditions.visibilityOf(macBookCost));
        return macBookCost;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getMacbookWishListButton() {
        return macbookWishListButton;
    }
}

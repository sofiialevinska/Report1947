package com.opencart.pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = ".//*[contains (@href, 'account/logout')]")
    private WebElement logoutButton;

    @FindBy(id = "form-currency")
    private WebElement currencyButton;

    @FindBy(css = "input[name = 'search']")
    private WebElement searchInput;

    @FindBy(css = "* button > i.fa.fa-search")
    private WebElement searchButton;

    @FindBy(css = "i[class=\"fa fa-heart\"] + .hidden-xs.hidden-sm.hidden-md")
    private WebElement wishListButton;

    @FindBy(css = "button[onclick=\"wishlist.add('43');\"]")
    private WebElement macbookWishListButton;

    public WebElement getMyAccountButton() {
        wait.until(ExpectedConditions.visibilityOf(myAccountButton));
        return myAccountButton;
    }

    public WebElement getLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getCurrencyButton() {
        wait.until(ExpectedConditions.visibilityOf(currencyButton));
        return currencyButton;
    }

    public WebElement getCurrencyButton(String currencyName) {
        return driver.findElement(By.xpath(".//*[@name='" + currencyName + "']"));
    }

    public WebElement getRegisterButton() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        return registerButton;
    }

    public WebElement getWishListButton() {
        return wishListButton;
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
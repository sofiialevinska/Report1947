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

    @FindBy (id = "cart-total")
    private WebElement shoppingCartButton;

    @FindBy (css = ".table.table-bordered tr:nth-child(3) .text-right:last-child")
    private WebElement productVatTaxRate;

    @FindBy (css = ".table.table-bordered tr:nth-child(3) .text-right:first-child strong")
    private WebElement productVatTaxName;

    @FindBy (css = ".table.table-bordered tr:nth-child(2) .text-right:last-child")
    private WebElement productEcoTaxRate;

    @FindBy (css = ".table.table-bordered tr:nth-child(2) .text-right:first-child strong")
    private WebElement productEcoTaxName;

    @FindBy (css = ".table.table-bordered tr:nth-child(1) .text-right:last-child")
    private WebElement productPrice;

    @FindBy (css = ".table.table-bordered tr:nth-child(4) .text-right:last-child")
    private WebElement productTotalPrice;

    @FindBy (css = "[title='Remove']")
    private WebElement deleteFromShoppingCartButton;

    public WebElement getMyAccountButton() {
        wait.until(ExpectedConditions.visibilityOf(myAccountButton));
        return myAccountButton;
    }

    public WebElement getRegisterButton() {
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        return registerButton;
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

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getShoppingCartButton() {
        wait.until(ExpectedConditions.visibilityOf(shoppingCartButton));
        return shoppingCartButton;
    }

    public WebElement getProductVatTaxRate() {
        return productVatTaxRate;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getProductVatTaxName() {
        return productVatTaxName;
    }

    public WebElement getProductEcoTaxName() {
        return productEcoTaxName;
    }

    public WebElement getProductEcoTaxRate() {
        return productEcoTaxRate;
    }

    public WebElement getProductTotalPrice() {
        return productTotalPrice;
    }

    public WebElement getDeleteFromShoppingCartButton() {
        return deleteFromShoppingCartButton;
    }
}

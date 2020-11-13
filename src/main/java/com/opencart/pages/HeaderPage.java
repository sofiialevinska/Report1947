package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPage extends BasePage {

    @FindBy(id = "form-currency")
    private WebElement currencyButton;

    @FindBy(name = "EUR")
    private WebElement euroButton;

    @FindBy(name = "USD")
    private WebElement usdButton;

    @FindBy(name = "GBP")
    private WebElement gbpButton;

    @FindBy(css = "div.product-thumb.transition:first-child")
    private WebElement macBookCost;

    public WebElement getCurrencyButton() {
        wait.until(ExpectedConditions.visibilityOf(currencyButton));
        return currencyButton;
    }

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
            default: {
                System.err.println("Can not switch to " + currencyName + " currency because this currency is not available. Please try again with another currency.");
                return null;
            }
        }
    }

    public WebElement getMacBookCost() {
        wait.until(ExpectedConditions.visibilityOf(macBookCost));
        return macBookCost;
    }
}

package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WishListPage extends BasePage {

    @FindBy(css = "div.pull-right > a")
    private WebElement continueButton;

    @FindBy(css = "#logo a")
    private WebElement yourStoreButton;

    @FindBy(css = "a.btn.btn-danger")
    private WebElement removeButton;

    @FindBy(css = ".alert.alert-success.alert-dismissible")
    private WebElement successModificationMessage;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement addToCartButton;

    public WebElement getAddToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        return addToCartButton;
    }

    public WebElement getRemoveButton() {
        wait.until(ExpectedConditions.visibilityOf(removeButton));
        return removeButton;
    }

    public WebElement getSuccessModificationMessage() {
        wait.until(ExpectedConditions.visibilityOf(successModificationMessage));
        return successModificationMessage;
    }

    public WebElement getYourStoreButton() {
        return yourStoreButton;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
}

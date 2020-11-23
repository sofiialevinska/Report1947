package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

    @FindBy(css = "div.pull-right > a")
    private WebElement continueButton;

    @FindBy(css = "#logo a")
    private WebElement yourStoreButton;

    @FindBy(css = "button.btn.btn-danger")
    private WebElement removeButton;

    @FindBy(className = "alert alert-success alert-dismissible")
    private WebElement successModificationMessage;

    public WebElement getRemoveButton() {
        return removeButton;
    }

    public WebElement getSuccessModificationMessage() {
        return successModificationMessage;
    }

    public WebElement getYourStoreButton() {
        return yourStoreButton;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
}

package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDashboard extends BasePage {

    @FindBy(xpath = ".//*[contains (@href, 'account/edit')]")
    private WebElement editAccountButton;

    @FindBy(xpath = ".//*[contains (@href, 'account/password')]")
    private WebElement editPasswordButton;

    @FindBy(id = "input-password")
    private WebElement passwordChangeInput;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmInput;

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueButton;

    @FindBy(css = ".alert")
    private WebElement successMessage;

    @FindBy(css = "#content > h2:first-child")
    private WebElement myAccount;

    public WebElement getEditAccountButton() {
        return editAccountButton;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getEmailInput() { return email; }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getEditPasswordButton() {
        return editPasswordButton;
    }

    public WebElement getPasswordChangeInput() {
        return passwordChangeInput;
    }

    public WebElement getPasswordConfirmInput() {
        return passwordConfirmInput;
    }

    public WebElement getMyAccount() {
        return myAccount;
    }
}

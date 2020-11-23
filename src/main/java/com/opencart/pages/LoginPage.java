package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement loginButton;

    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    private WebElement warning;

    @FindBy(css = ".alert.alert-success.alert-dismissible")
    private WebElement successSentToEmail;

    @FindBy(css = "#input-password + a")
    private WebElement forgottenButton;

    @FindBy(css = "#logo a")
    private WebElement yourStoreButton;

    public WebElement getYourStoreButton() {
        return yourStoreButton;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWarning() {
        return warning;
    }

    public WebElement getSuccessSentToEmail() {
        return successSentToEmail;
    }

    public WebElement getForgottenButton() {
        return forgottenButton;
    }
}

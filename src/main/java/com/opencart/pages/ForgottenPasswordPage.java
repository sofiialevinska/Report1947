package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenPasswordPage extends BasePage{
    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(css = "input[type = 'submit']")
    private WebElement continueButton;

    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    private WebElement warningText;

    public WebElement getWarningText() {
        return warningText;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
}

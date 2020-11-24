package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage extends BasePage {

    @FindBy(id = "input-username")
    private WebElement usernameInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(css = ".btn.btn-primary")
    private WebElement submitButton;

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}
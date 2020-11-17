package com.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmInput;

    @FindBy(name = "agree")
    private WebElement policy;

    @FindBy(xpath = ".//*[@type='submit']")
    private WebElement continueButton;

    @FindBy(css = ".alert.alert-danger.alert-dismissible")
    private WebElement privacyPolicyWarning;

    @FindBy(css = "#input-firstname + .text-danger")
    private WebElement nameErrorText;

    @FindBy(css = "#input-lastname + .text-danger")
    private WebElement lastNameErrorText;

    @FindBy(css = "#input-email + .text-danger")
    private WebElement emailErrorText;

    @FindBy(css = "#input-telephone + .text-danger")
    private WebElement telephoneErrorText;

    public WebElement getSubscribeRadioButton(int value) {
        return driver.findElement(By.xpath("//*[@type = 'radio' and @value = '" + value + "']"));
    }


    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getPasswordConfirmInput() {
        return passwordConfirmInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getPolicy() {
        return policy;
    }

    public WebElement getTelephoneInput() {
        return telephoneInput;
    }

    public WebElement getPrivacyPolicyWarning() {
        return privacyPolicyWarning;
    }

    public WebElement getNameErrorText() {
        return nameErrorText;
    }

    public WebElement getLastNameErrorText() {
        return lastNameErrorText;
    }

    public WebElement getEmailErrorText() {
        return emailErrorText;
    }

    public WebElement getTelephoneErrorText() {
        return telephoneErrorText;
    }
}
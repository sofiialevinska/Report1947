package com.opencart.steps;

import com.opencart.datamodel.LoginModel;
import com.opencart.pages.AccountDashboard;
import org.testng.Assert;

public class AccountDashboardBL {
    private final AccountDashboard accountDashboard;

    public AccountDashboardBL() {
        accountDashboard = new AccountDashboard();
    }

    public AccountDashboardBL setNewName() {
        LoginModel loginModel = new LoginModel();
        inputNewFirstName(loginModel.getNewFirstName());
        clickOnContinueButton();
        return this;
    }

    public AccountDashboardBL setNewEmail() {
        LoginModel loginModel = new LoginModel();
        inputEmail(loginModel.getNewEmail());
        clickOnContinueButton();
        return this;
    }

    public AccountDashboardBL returnOldEmail() {
        LoginModel loginModel = new LoginModel();
        inputEmail(loginModel.getEmail());
        clickOnContinueButton();
        return this;
    }

    public AccountDashboardBL setNewPassword() {
        LoginModel loginModel = new LoginModel();
        inputPassword(loginModel.getNewPassword());
        clickOnContinueButton();
        return this;
    }

    public AccountDashboardBL returnOldPassword() {
        LoginModel loginModel = new LoginModel();
        inputPassword(loginModel.getPassword());
        clickOnContinueButton();
        return this;
    }

    private void inputNewFirstName(String newFirstName) {
        accountDashboard.getFirstNameInput().clear();
        accountDashboard.getFirstNameInput().sendKeys(newFirstName);
    }

    private void inputEmail(String email) {
        accountDashboard.getEmailInput().clear();
        accountDashboard.getEmailInput().sendKeys(email);
    }

    private void inputPassword(String password) {
        accountDashboard.getPasswordChangeInput().clear();
        accountDashboard.getPasswordChangeInput().sendKeys(password);
        accountDashboard.getPasswordConfirmInput().clear();
        accountDashboard.getPasswordConfirmInput().sendKeys(password);
    }

    private void clickOnContinueButton() {
        accountDashboard.getContinueButton().click();
    }

    public AccountDashboardBL clickOnEditPasswordButton() {
        accountDashboard.getEditPasswordButton().click();
        return this;
    }

    public AccountDashboardBL clickOnEditAccountButton() {
        accountDashboard.getEditAccountButton().click();
        return this;
    }

    public AccountDashboardBL verifyAccountEdit() {
        String expectedMessage = "Success: Your account has been successfully updated.";
        Assert.assertEquals(accountDashboard.getSuccessMessage().getText(), expectedMessage, "\nSuccess message after editing Account information did not appear.");
        return this;
    }

    public AccountDashboardBL verifyPasswordEdit() {
        String expectedMessage = "Success: Your password has been successfully updated.";
        Assert.assertEquals(accountDashboard.getSuccessMessage().getText(), expectedMessage, "\nSuccess message after editing Account information did not appear.");
        return this;
    }

}

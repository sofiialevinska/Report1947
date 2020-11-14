package com.opencart.steps;

import com.opencart.datamodel.LoginModel;
import com.opencart.pages.AccountDashboard;
import com.opencart.pages.LoginPage;

public class LoginPageBL {
    private final LoginPage loginPage;
    private AccountDashboard accountDashboard;

    public LoginPageBL() {
        loginPage = new LoginPage();
    }

    public LoginPageBL login() {
        LoginModel loginModel = new LoginModel();
        inputEmail(loginModel.getEmail());
        inputPassword(loginModel.getPassword());
        clickOnLoginButton();

        accountDashboard = new AccountDashboard();
        return this;
    }

    public LoginPageBL loginWithNewEmail() {
        LoginModel loginModel = new LoginModel();
        inputEmail(loginModel.getNewEmail());
        inputPassword(loginModel.getPassword());
        clickOnLoginButton();

        accountDashboard = new AccountDashboard();
        return this;
    }

    private void inputEmail(String email) {
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
    }

    private void inputPassword(String password) {
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
    }

    private void clickOnLoginButton() {
        loginPage.getLoginButton().click();
    }

}

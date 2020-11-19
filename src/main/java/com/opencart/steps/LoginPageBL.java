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

    /**
     * Method logins user using valid data.
     *
     * @return LoginPageBL
     */
    public LoginPageBL login() {
        LoginModel loginModel = new LoginModel();
        inputEmail(loginModel.getEmail());
        inputPassword(loginModel.getPassword());
        clickOnLoginButton();

        accountDashboard = new AccountDashboard();
        return this;
    }

    /**
     * Method logins user using NewEmail that was through Edit Account.
     *
     * @return LoginPageBL
     */
    public LoginPageBL loginWithNewEmail() {
        LoginModel loginModel = new LoginModel();
        inputEmail(loginModel.getNewEmail());
        inputPassword(loginModel.getPassword());
        clickOnLoginButton();

        accountDashboard = new AccountDashboard();
        return this;
    }

    /**
     * Method inputs email to email input field on the login page.
     *
     * @param email is email that will be put on the login page.
     */
    private void inputEmail(String email) {
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
    }

    /**
     * Method inputs password to password input field on the login page.
     *
     * @param password is password that will be put on the login page.
     */
    private void inputPassword(String password) {
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
    }

    /**
     * Method clicks on Login Button on the login page.
     */
    private void clickOnLoginButton() {
        loginPage.getLoginButton().click();
    }

}

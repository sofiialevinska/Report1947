package com.opencart.steps;

import com.opencart.datamodel.LoginModel;
import com.opencart.pages.AccountDashboard;
import com.opencart.pages.LoginPage;
import org.testng.Assert;


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
        inputEmail("newEmail@gmail.com");
        inputPassword(loginModel.getPassword());
        clickOnLoginButton();

        accountDashboard = new AccountDashboard();
        return this;
    }

    public LoginPageBL userLogin(LoginModel loginModel) {
        inputEmail(loginModel.getEmail());
        inputPassword(loginModel.getPassword());
        clickOnLoginButton();

        accountDashboard = new AccountDashboard();
        return this;
    }

    public ForgottenPasswordPageBL clickOnForgottenPassword() {
        clickOnForgottenPasswordButton();
        return new ForgottenPasswordPageBL();
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

    private void clickOnForgottenPasswordButton() {
        loginPage.getForgottenButton().click();
    }

    public void verifyLogin() {
        String expectedText = "My Account";
        Assert.assertEquals(accountDashboard.getMyAccount().getText(), expectedText, "You are not logged In!");
    }

    public void verifyLoginWithoutPassword() {
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginPage.getWarning().getText(), expectedMessage, "You are logged in!");
    }

    public void verifyLoginWithoutEmail() {
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password."
                + "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
        Assert.assertTrue(expectedMessage.contains(loginPage.getWarning().getText()),
                "You are logged in!");
    }

    public void verifyLoginWithInvalidData() {
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginPage.getWarning().getText(), expectedMessage, "You are logged in!");
    }

    public void verifyLoginWithEmptyFields() {
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password." +
                "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
        Assert.assertTrue(expectedMessage.contains(loginPage.getWarning().getText()), "You are logged in!");
    }

    public void verifyForgottenPasswordText() {
        String expectedMessage = "An email with a confirmation link has been sent your email address.";
        Assert.assertEquals(loginPage.getSuccessSentToEmail().getText(), expectedMessage, "You made error!");
    }
}

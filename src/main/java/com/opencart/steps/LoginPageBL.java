package com.opencart.steps;

import com.opencart.datamodel.LoginModel;
import com.opencart.pages.AccountDashboard;
import com.opencart.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;


public class LoginPageBL {
    private final LoginPage loginPage;
    private AccountDashboard accountDashboard;

    public LoginPageBL() {
        loginPage = new LoginPage();
    }

    @Step("login to Main Page")
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

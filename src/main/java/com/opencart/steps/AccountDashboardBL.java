package com.opencart.steps;

import com.opencart.datamodel.LoginModel;
import com.opencart.pages.AccountDashboard;
import org.testng.Assert;

public class AccountDashboardBL {
    private final AccountDashboard accountDashboard;

    public AccountDashboardBL() {
        accountDashboard = new AccountDashboard();
    }

    /**
     * Method sets new First Name on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL setNewName() {
        LoginModel loginModel = new LoginModel();
        inputNewFirstName("NewFirstName");
        clickOnContinueButton();
        return this;
    }

    /**
     * Method sets new Email on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL setNewEmail() {
        LoginModel loginModel = new LoginModel();
        inputEmail("newEmail@gmail.com");
        clickOnContinueButton();
        return this;
    }

    /**
     * Method sets old Email on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL returnOldEmail() {
        LoginModel loginModel = new LoginModel();
        inputEmail(loginModel.getEmail());
        clickOnContinueButton();
        return this;
    }

    /**
     * Method sets new Password on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL setNewPassword() {
        LoginModel loginModel = new LoginModel();
        inputPassword("newPassword");
        clickOnContinueButton();
        return this;
    }

    /**
     * Method sets old Password on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL returnOldPassword() {
        LoginModel loginModel = new LoginModel();
        inputPassword(loginModel.getPassword());
        clickOnContinueButton();
        return this;
    }

    /**
     * Method inputs new First Name data to the First Name field on the Edit Account page.
     */
    private void inputNewFirstName(String newFirstName) {
        accountDashboard.getFirstNameInput().clear();
        accountDashboard.getFirstNameInput().sendKeys(newFirstName);
    }

    /**
     * Method inputs Email data to the First Name field on the Edit Account page.
     *
     * @param email is Email data
     */
    private void inputEmail(String email) {
        accountDashboard.getEmailInput().clear();
        accountDashboard.getEmailInput().sendKeys(email);
    }

    /**
     * Method inputs new Password data to the Password and Confirm Password fields
     * on the Edit Account page.
     *
     * @param password is Password data
     */
    private void inputPassword(String password) {
        accountDashboard.getPasswordChangeInput().clear();
        accountDashboard.getPasswordChangeInput().sendKeys(password);
        accountDashboard.getPasswordConfirmInput().clear();
        accountDashboard.getPasswordConfirmInput().sendKeys(password);
    }

    /**
     * Method clicks on Continue Button on the Edit Account page.
     */
    private void clickOnContinueButton() {
        accountDashboard.getContinueButton().click();
    }

    /**
     * Method clicks on Edit Password Button on the Edit Account dashboard page.
     */
    public AccountDashboardBL clickOnEditPasswordButton() {
        accountDashboard.getEditPasswordButton().click();
        return this;
    }

    /**
     * Method clicks on Edit Account Button on the Edit Account dashboard page.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL clickOnEditAccountButton() {
        accountDashboard.getEditAccountButton().click();
        return this;
    }

    /**
     * Method verifies if Success message appears after User Account was edited
     * and Continue Button was clicked.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL verifyAccountEdit() {
        String expectedMessage = "Success: Your account has been successfully updated.";
        Assert.assertEquals(accountDashboard.getSuccessMessage().getText(), expectedMessage, "\nSuccess message after editing Account information did not appear.");
        return this;
    }

    /**
     * Method verifies if Success message appears after User Password was edited
     * and Continue Button was clicked.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL verifyPasswordEdit() {
        String expectedMessage = "Success: Your password has been successfully updated.";
        Assert.assertEquals(accountDashboard.getSuccessMessage().getText(), expectedMessage, "\nSuccess message after editing Account information did not appear.");
        return this;
    }
}

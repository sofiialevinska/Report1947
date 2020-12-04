package com.opencart.steps;

import com.opencart.pages.AccountDashboard;
import com.opencart.pages.RegisterPage;
import com.opencart.util.DriverUtils;
import io.qameta.allure.Step;
import org.testng.Assert;

public class AccountDashboardBL {
    private final AccountDashboard accountDashboard;

    public AccountDashboardBL() {
        accountDashboard = new AccountDashboard();
    }


    @Step ("click on Edit Password Button on the Edit Account dashboard page")
    /**
     * Method clicks on Edit Password Button on the Edit Account dashboard page.
     */
    public AccountDashboardBL clickOnEditPasswordButton() {
        accountDashboard.getEditPasswordButton().click();
        return this;
    }

    @Step ("click on Edit Account Button on the Edit Account dashboard page")
    /**
     * Method clicks on Edit Account Button on the Edit Account dashboard page.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL clickOnEditAccountButton() {
        accountDashboard.getEditAccountButton().click();
        return this;
    }

    @Step ("set new First Name on the Edit Account page and click on continue Button")
    /**
     * Method sets new First Name on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL setNewName() {
        inputNewFirstName("NewFirstName");
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

    @Step ("set new Email on the Edit Account page and click on continue Button")
    /**
     * Method sets new Email on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL setNewEmail(String newEmail) {
        inputEmail(newEmail);
        clickOnContinueButton();
        return this;
    }

    @Step ("set origin Email on the Edit Account page and click on continue Button")
    /**
     * Method sets old Email on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL returnOldEmail() {
        inputEmail("dfghszdfgh@gmail.com");
        clickOnContinueButton();
        return this;
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

    @Step ("set new Password on the Edit Account page and click on continue Button")
    /**
     * Method sets new Password on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL setNewPassword(String newPassword) {
        inputPassword(newPassword);
        clickOnContinueButton();
        return this;
    }

    @Step ("set origin Password on the Edit Account page and click on continue Button")
    /**
     * Method sets old Password on the Edit Account page and click on continue Button.
     *
     * @return AccountDashboardBL
     */
    public AccountDashboardBL returnOldPassword() {
        inputPassword("dfghszdfgh");
        clickOnContinueButton();
        return this;
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
     * Method verifies if Success message appears after User Account was edited
     * and Continue Button was clicked.
     *
     * @return AccountDashboardBL
     */

    @Step ("verifyAccountEdit")
    public AccountDashboardBL verifyAccountEdit() {
        String expectedMessage = "Success: Your account has been successfully updated.";
        Assert.assertEquals(accountDashboard.getSuccessMessage().getText(), expectedMessage, "\nSuccess message after editing Account information did not appear.");
        return this;
    }

    @Step ("verifyPasswordEdit")
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

    @Step ("clickOnEditSubscriptionButton")
    public AccountDashboardBL clickOnEditSubscriptionButton() {
        accountDashboard.getEditNewsletterSubscriptionButton().click();
        return this;
    }

    @Step ("chooseOtherSubscription")
    public AccountDashboardBL chooseOtherSubscription() {
        int currentSubscriptionValue = findCurrentSubscription();
        if (currentSubscriptionValue == 0) {
            chooseSubscription(1);
        } else if (currentSubscriptionValue == 1) {
            chooseSubscription(0);
        }
        clickOnContinueButton();
        return this;
    }

    private void chooseSubscription(int value) {
        new DriverUtils().clickOnElementJS(new RegisterPage().getSubscribeRadioButton(value));
    }

    private int findCurrentSubscription() {
        return Integer.parseInt(accountDashboard.getSubscribeOption().getAttribute("value"));
    }

    @Step ("verifySubscriptionEdit")
    public void verifySubscriptionEdit() {
        String expectedMessage = "Success: Your newsletter subscription has been successfully updated!";
        Assert.assertEquals(accountDashboard.getSuccessMessage().getText(), expectedMessage, "\nSuccess message after editing Subscription settings did not appear.");
    }
}
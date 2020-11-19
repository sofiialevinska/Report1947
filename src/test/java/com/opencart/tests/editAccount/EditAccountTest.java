package com.opencart.tests.editAccount;

import com.opencart.navigation.Navigation;
import com.opencart.steps.AccountDashboardBL;
import com.opencart.steps.HeaderPageBL;
import com.opencart.steps.LoginPageBL;
import com.opencart.steps.MainPageBL;
import com.opencart.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.opencart.enums.URLs.BASE_URL;

public class EditAccountTest extends BaseTest {

    private MainPageBL mainPageBL;
    private HeaderPageBL headerPageBL;
    private LoginPageBL loginPageBL;
    private AccountDashboardBL accountDashboardBL;

    /**
     * Method @BeforeMethod login to user account using valid data.
     */
    @BeforeMethod
    public void loginUsingValidData() {
        new Navigation().navigateToURrl(BASE_URL.getValue());
        mainPageBL = new MainPageBL();
        headerPageBL = mainPageBL.getHeaderPageBL();
        loginPageBL = new LoginPageBL();
        accountDashboardBL = new AccountDashboardBL();
        headerPageBL
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        loginPageBL
                .login();
    }

    @Test(description = "Test checks if customer can change email to newEmail, " +
            "safe changes and change email to oldEmail")
    public void changeUserEmailToNewToOld() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewEmail()
                .verifyAccountEdit()
                .clickOnEditAccountButton()
                .returnOldEmail();
    }

    @Test(description = "Test checks if customer can change email to newEmail, logout and login\n" +
            "with newEmail and change email to previousEmail")
    public void changeUserEmailToNewLogoutLoginChangeUserEmailToOld() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewEmail()
                .verifyAccountEdit();
        headerPageBL.clickOnMyAccountButton()
                .clickOnLogoutButton()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        loginPageBL.loginWithNewEmail();
        accountDashboardBL
                .clickOnEditAccountButton()
                .returnOldEmail()
                .verifyAccountEdit();
    }

    @Test(description = "Test checks if customer can change First Name to new First Name")
    public void changeUserName() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewName()
                .verifyAccountEdit();
    }

    @Test(description = "Test checks if customer can change Password to new Password " +
            "and change it back to previous Password")
    public void changePassword() {
        accountDashboardBL
                .clickOnEditPasswordButton()
                .setNewPassword()
                .verifyPasswordEdit()
                .clickOnEditPasswordButton()
                .returnOldPassword()
                .verifyPasswordEdit();
    }

    @Test(description = "Test checks if customer can change Password to newPassword, logout and login\n" +
            "with newPassword and change Password to previousPassword")
    public void changePasswordVerifyLogin() {
        accountDashboardBL
                .clickOnEditPasswordButton()
                .setNewPassword()
                .verifyPasswordEdit();
        headerPageBL.clickOnMyAccountButton()
                .clickOnLogoutButton()
                .clickOnMyAccountButton()
                .clickOnLoginButton();
        loginPageBL.loginWithNewPassword();
        accountDashboardBL
                .clickOnEditPasswordButton()
                .returnOldPassword()
                .verifyPasswordEdit();
    }

    /**
     * Method @AfterMethod logout from user account.
     */
    @AfterMethod
    public void logout() {
        headerPageBL
                .clickOnMyAccountButton()
                .clickOnLogoutButton();
    }
}
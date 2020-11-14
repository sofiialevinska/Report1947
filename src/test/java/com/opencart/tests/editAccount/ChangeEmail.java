package com.opencart.tests.editAccount;

import org.testng.annotations.Test;

public class ChangeEmail extends LoginUsingValidData_Logout {

    /**
     * Test checks if customer can change email to newEmail, logout and login with newEmail.
     */
    @Test
    public void changeUserEmailToNewToOld() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewEmail()
                .verifyAccountEdit()
                .clickOnEditAccountButton()
                .returnOldEmail();
    }

    /**
     * Test checks if customer can change email to newEmail, logout and login with newEmail.
     */
    @Test
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
}


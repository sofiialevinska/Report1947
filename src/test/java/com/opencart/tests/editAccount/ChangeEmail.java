package com.opencart.tests.editAccount;

import org.testng.annotations.Test;

public class ChangeEmail extends LoginUsingValidData_Logout {

    @Test (description = "Test checks if customer can change email to newEmail, " +
            "safe changes and change email to oldEmail.")
    public void changeUserEmailToNewToOld() {
        accountDashboardBL
                .clickOnEditAccountButton()
                .setNewEmail()
                .verifyAccountEdit()
                .clickOnEditAccountButton()
                .returnOldEmail();
    }

    @Test (description = "Test checks if customer can change email to newEmail, logout and login with newEmail and " +
            "change email to previousEmail.")
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


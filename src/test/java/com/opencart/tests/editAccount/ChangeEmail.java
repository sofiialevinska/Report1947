package com.opencart.tests.editAccount;

import com.opencart.datamodel.LoginModel;
import com.opencart.repository.LoginModelRepository;
import org.testng.annotations.Test;

public class ChangeEmail extends LoginUsingValidData_Logout {

    /**
     * Test checks if customer can change email to newEmail, safe changes and change email to oldEmail.
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
     * Test checks if customer can change email to newEmail, logout and login
     * with newEmail and change email to previousEmail.
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
        LoginModel loginModel = LoginModelRepository.getLoginWithNewEmail();
        loginPageBL.userLogin(loginModel);
        accountDashboardBL
                .clickOnEditAccountButton()
                .returnOldEmail()
                .verifyAccountEdit();
    }
}

